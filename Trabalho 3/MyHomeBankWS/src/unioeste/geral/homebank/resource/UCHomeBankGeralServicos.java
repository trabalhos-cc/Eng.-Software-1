package unioeste.geral.homebank.resource;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import unioeste.apoio.MySQL.ConexaoBD;
import unioeste.geral.exception.ClienteException;
import unioeste.geral.exception.MovimentacaoException;
import unioeste.geral.homebank.bo.ContaBancaria;
import unioeste.geral.homebank.bo.Motivo;
import unioeste.geral.homebank.bo.Movimentacao;
import unioeste.geral.homebank.col.ColAgencia;
import unioeste.geral.homebank.col.ColBanco;
import unioeste.geral.homebank.col.ColCliente;
import unioeste.geral.homebank.col.ColContaBancaria;
import unioeste.geral.homebank.col.ColMovimentacao;

@Path("/UCHomeBankGeralServicos")
public class UCHomeBankGeralServicos {

	@Context
	private Connection con;

	public UCHomeBankGeralServicos() throws Exception {

		try {
			this.con = ConexaoBD.getConnection();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/teste")
	@Produces(MediaType.APPLICATION_JSON)
	public String teste() {
		return "HEllo World!";
	}
	
	
	@GET
	@Path("/consultarExtatoConta/{consultado}/{docFav}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<String> consultarExtratoConta(@PathParam("consultado")String consultado,
			@PathParam("docFav")String docFav) throws ClienteException {

		ColCliente colC = new ColCliente(con);

		int idCli = colC.validar(consultado, docFav);
		System.out.println(idCli);
		if(idCli != 0) {

			ColContaBancaria colCB = new ColContaBancaria(con);

			ContaBancaria cb = null;
			try {
				cb = colCB.getConta(idCli);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if(cb != null) {

				ColMovimentacao colLB = new ColMovimentacao(con);

				ArrayList<String> movimentacoes = null;
				try {
					movimentacoes = colLB.getLancamentos(cb.getNroConta());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

				movimentacoes.add(String.valueOf(cb.getSaldo()));
				return movimentacoes;
			}
			else {
				throw new ClienteException("Conta Bancária do Cliente não cadastrada");
			}
		}
		else
			throw new ClienteException("Cliente não Valido");
		
	}
	
	@SuppressWarnings("static-access")
	public int registrarTransferenciaBancaria(String correntista, String docCorre, String favorecido, String docFav, Date dataTrans, int conta,
			int favConta, int favBanco, int favAgencia, double valorTrans) throws NumberFormatException, Exception{
		
		Date atual = new Date(), tresDias, local;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(atual); // Objeto Date() do usuário
		cal.add(cal.DAY_OF_MONTH, +3);
		
		tresDias = cal.getTime();
		
		cal.setTime(atual);
		cal.add(cal.DAY_OF_MONTH, -1);
		
		local = cal.getTime();
		
		ColCliente colCli = new ColCliente(con);
		
		int idCli = colCli.validar(correntista, docCorre);
		
		if(idCli != 0) {
			
			ColContaBancaria colContBan = new ColContaBancaria(con);
			
			int idFav = colCli.validar(favorecido, docFav);
			
			if(idFav != 0) {
				
				if((dataTrans.after(local)) && dataTrans.before(tresDias)) {
					
					ColBanco colB = new ColBanco(con);
					
					int idBanco = colB.valida(favBanco);
					
					ColAgencia colA = new ColAgencia(con);
					
					int idAgencia = colA.valida(favAgencia);
					
					if(idBanco != 0 && idAgencia != 0) {
						
						ContaBancaria CorreConta = colContBan.getConta(conta);
						ContaBancaria FavConta = colContBan.getConta(favConta);
						
						if(valorTrans > 1.0 && valorTrans <= CorreConta.getSaldo()) {
							
							Motivo mt = new Motivo();
							mt.setIdMotivo(10);
							mt.setNomeMotivo("Transfêrencia Bancária");
							
							ColMovimentacao cLB = new ColMovimentacao(con);
							Movimentacao MoviCorrentista = new Movimentacao();
							int idMov = cLB.getMovNextID();
							
							MoviCorrentista.setDataMovimentacao(new java.sql.Date(dataTrans.getTime()));
							MoviCorrentista.setIdMovimentacao(idMov);
							MoviCorrentista.setMot(mt);
							MoviCorrentista.setValor(valorTrans);
							
							int correInseriu = cLB.insertLancamento(MoviCorrentista, CorreConta.getNroConta());
							
							if(correInseriu == 1) {
								colContBan.atualizaSaldo(CorreConta.getNroConta(), CorreConta.getSaldo()-valorTrans);
								
								Movimentacao MoviFavorecido = new Movimentacao();
								MoviFavorecido.setDataMovimentacao(new java.sql.Date(dataTrans.getTime()));
								MoviFavorecido.setIdMovimentacao(idMov+1);
								MoviFavorecido.setMot(mt);
								MoviFavorecido.setValor(valorTrans);
								
								int favInseriu = cLB.insertLancamento(MoviFavorecido, FavConta.getNroConta());
								
								if(favInseriu == 1) {
									colContBan.atualizaSaldo(FavConta.getNroConta(), FavConta.getSaldo()+valorTrans);
								
									return 1;
								}
								else
									throw new MovimentacaoException("A inserção da Movimentação na conta do Favorecido gerou um erro");
							}
							else
								throw new MovimentacaoException("A inserção da Movimentação na conta do Correntista gerou um erro");
						}
						else
							throw new MovimentacaoException("Valor de Transfêrencia é menor que R$ 1 ou maior que o saldo do Cliente");
					}
					
				}
				else
					throw new MovimentacaoException("Data Transferência não é igual ou superior (3 dias a mais) da data atual");
			}	
			else
				throw new ClienteException("Favorecido não Cadastrado");
		}
		else
			throw new ClienteException("Cliente não Cadastrado");
		
		return 0;
	}
}

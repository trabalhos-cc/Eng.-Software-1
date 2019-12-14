package unioeste.geral.homebank.resource;

import java.sql.Connection;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import unioeste.apoio.MySQL.ConexaoBD;
import unioeste.geral.exception.ClienteException;
import unioeste.geral.homebank.bo.ContaBancaria;
import unioeste.geral.homebank.col.ColCliente;
import unioeste.geral.homebank.col.ColContaBancaria;
import unioeste.geral.homebank.col.ColMovimentacao;

@Path("/UCHomeBankGeralServicos")
public class UCHomeBankGeralServicos {

	private Connection con;

	public UCHomeBankGeralServicos() throws Exception {

		try {
			this.con = ConexaoBD.getConnection();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/consultarExtatoConta")
	@Produces("application/json")
	public ArrayList<String> consultarExtratoConta(String consultado, String docFav) throws ClienteException {

		ColCliente colC = new ColCliente(con);

		int idCli = colC.validar(consultado, docFav);

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
}

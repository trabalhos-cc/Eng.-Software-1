package unioeste.geral.homebank.rest;

import java.sql.Connection;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import unioeste.apoio.MySQL.ConexaoBD;
import unioeste.geral.exception.ClienteException;
import unioeste.geral.homebank.bo.ContaBancaria;
import unioeste.geral.homebank.col.ColCliente;
import unioeste.geral.homebank.col.ColContaBancaria;
import unioeste.geral.homebank.col.ColMovimentacao;

@Path("restws")
public class UCHomeBankGeralServicos {
	@SuppressWarnings("unused")
	@Context
	private UriInfo context;
	private Connection con;

	/**
	 * Default constructor. 
	 */
	public UCHomeBankGeralServicos() {
		// TODO Auto-generated constructor stub
		try {
			this.con = ConexaoBD.getConnection();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("ConsultarExtratoConta/{cons}/{doc}")
	public ArrayList<String> consultarExtratoConta(@PathParam("cons")String consultado, @PathParam("doc")String docFav) throws ClienteException {

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


//	/**
//	 * PUT method for updating or creating an instance of UCHomeBankGeralServicos
//	 * @param content representation for the resource
//	 * @return an HTTP response with content of the updated or created resource.
//	 */
//	@PUT
//	@Consumes("application/json")
//	public void putJson(String content) {
//	}

}
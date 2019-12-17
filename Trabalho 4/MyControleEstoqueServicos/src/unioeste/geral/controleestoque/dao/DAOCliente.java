package unioeste.geral.controleestoque.dao;

import java.sql.Connection;

import unioeste.apoio.MySQL.ConexaoBD;
import unioeste.geral.controleestoque.exception.ControleEstoqueException;

public class DAOCliente {

	private Connection conn;

	public DAOCliente(Connection con) {
		this.conn = con;
	}
	
	public int getClienteId(String nome) throws ControleEstoqueException {
		
		ConexaoBD conect = new ConexaoBD();
		String res = null;
		try {
			res = conect.getSelect(conn, "SELECT idcliente FROM cliente WHERE nome='"+nome+"';");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res != null) {
			return Integer.parseInt(res);
		}
		else
			throw new ControleEstoqueException("Cliente com o nome de "+nome+" n�o est� cadastrado no banco de dados!");
	}

	public String getNomeCliente(String query) throws ControleEstoqueException {
		// TODO Auto-generated method stub

		ConexaoBD conect = new ConexaoBD();
		String res= null;
		try {
			res = conect.getSelect(conn, query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(res == null) {
			throw new ControleEstoqueException("Cliente consultado n�o existe!");
		}else
			return res;
	}
}

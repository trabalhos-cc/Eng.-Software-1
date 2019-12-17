package unioeste.geral.homebank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import unioeste.apoio.MySQL.ConexaoBD;

public class DaoMovimentacao {

	private Connection con;
	
	public DaoMovimentacao(Connection conn) {
		con = conn;
	}

	public int selectMaxID() throws NumberFormatException, Exception {

		return Integer.parseInt(ConexaoBD.getSelect(con, "SELECT MAX(idMovimenta��o) FROM Movimenta��o;"));
	}

	public ArrayList<String> getMovimentacao(int nroConta) throws Exception {

		String sql = "SELECT Movimenta��o.data, TipoMovimenta��o.idTipoMovimenta��o, TipoMovimenta��o.nome, Movimenta��o.valor "
				+ "FROM Movimenta��o, TipoMovimenta��o WHERE Movimenta��o.idConta = "+nroConta+" AND Movimenta��o.idTipoMovimenta��o = TipoMovimenta��o.idTipoMovimenta��o;";
		
		ArrayList<String> res = ConexaoBD.getTabela(con, sql);
		
		for(String a: res) System.out.println(a);
		
		System.out.println(res.size());
		
		return res;
	}

	public int insertMoviSQL(int idMovimentacao, double valor, int nroConta, Date date, int idMotivo) {

		String query = "INSERT INTO Movimenta��o (idMovimenta��o, data, valor, idTipoMovimenta��o, idConta) VALUES ('"+idMovimentacao+"', '"+date+"', "
				+ "'"+valor+"', '"+idMotivo+"', '"+nroConta+"');";
		
		try {
			
			ConexaoBD.insereSQLComand(con, query);
			
			return 1;
		}catch(Exception e) { e.printStackTrace();}
		
		return 0;
	}
}
/*private int idLancamento;
private double valor;
private ContaBancaria cliConta;
private Date dataLancamento;
private Motivo mot;*/
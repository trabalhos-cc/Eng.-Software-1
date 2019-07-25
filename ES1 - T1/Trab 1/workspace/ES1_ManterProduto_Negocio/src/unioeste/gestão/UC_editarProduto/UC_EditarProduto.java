package unioeste.gestão.UC_editarProduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connect.Connect;
import unioeste.gestão.UC_buscaProduto.UC_BuscaProduto;

public class UC_EditarProduto {

	protected ResultSet result = null;
	protected Statement st = null;
	UC_BuscaProduto bp = new UC_BuscaProduto();
	
	public UC_EditarProduto() {};
	
	public void EditarProduto(int id, String status, Double valorVenda)throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		Connection conn = Connect.toConnect();
		
		try {
			sql.append("update produto set idStatusProduto =" + bp.buscaIdStatusProduto(status)+ " where idProduto = " + id + ";");
			//sql.append("update produto set valorVenda =" + valorVenda + " where idProduto = " + id + ";");
			
			
			
			st = conn.createStatement();
			PreparedStatement comando = conn.prepareStatement(sql.toString());
			comando.executeUpdate();
			
			while(result.next()) {};
			
			comando.close();
			
		}catch(Exception e) {
			System.err.println(e);
		}
	
		
		conn.close();
	}
	
}

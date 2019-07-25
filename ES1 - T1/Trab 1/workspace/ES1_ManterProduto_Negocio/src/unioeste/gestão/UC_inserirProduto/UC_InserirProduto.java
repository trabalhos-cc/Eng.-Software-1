package unioeste.gestão.UC_inserirProduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import connect.Connect;
import unioeste.gestão.UC_buscaProduto.UC_BuscaProduto;


public class UC_InserirProduto {

	protected ResultSet result = null;
	protected Statement st = null;
	UC_BuscaProduto bp = new UC_BuscaProduto();
	
	public UC_InserirProduto() {};
	
	public void inserirProduto(String nomeProduto, double valorPago, double valorCusto, String origem, String status, String tipo, String fornecedor)throws Exception{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("insert into produto (nomeProduto, valorVenda, valorCusto, idOrigemProduto, idStatusProduto, idtipoProduto, idfornecedor)");
		sql.append("values (?,?,?,?,?,?,?);");
		
		Connection conn = Connect.toConnect();
		
		st = conn.createStatement();
		
		PreparedStatement comando = conn.prepareStatement(sql.toString());
		comando.setString(1, nomeProduto);
		comando.setDouble(2, valorPago);
		comando.setDouble(3, valorCusto);
		comando.setInt(4, bp.buscaIdOrigemProduto(origem));
		comando.setInt(5, bp.buscaIdStatusProduto(status));
		comando.setInt(6, bp.buscaIdTipoProduto(tipo));
		comando.setInt(7, bp.buscaIdFornecedor(fornecedor));
		comando.executeUpdate();
	
		comando.close();
		conn.close();
	}
	
	
	
}

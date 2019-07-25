package unioeste.gestão.UC_buscaProduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.Connect;
import unioeste.geral.fornecedor.Fornecedor;
import unioeste.geral.origemProduto.OrigemProduto;
import unioeste.geral.produto.Produto;
import unioeste.geral.statusProduto.StatusProduto;
import unioeste.geral.tipoProduto.TipoProduto;

public class UC_BuscaProduto {

	
	
public List <Produto> buscaProdutos (String nome) throws Exception{
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = Connect.toConnect();
		
		List<Produto> produtos = new ArrayList<>();
		
		try {
			
			stmt = conn.prepareStatement("select nomeProduto, valorVenda, idOrigemProduto, idStatusProduto, idTipoProduto from produto where nomeProduto = '" + nome + "';");
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				Produto ma = new Produto();
				ma.setNomeProduto(rs.getString("nomeProduto"));
				ma.setValorVenda(rs.getDouble("valorVenda"));
				ma.setIdOrigemProduto(this.buscarOrigem(rs.getInt("idOrigemProduto")));
				ma.setIdStatusProduto(this.buscarStatus(rs.getInt("idStatusProduto")));
				ma.setIdTipoProduto(this.buscarTipo(rs.getInt("idTipoProduto")));
				produtos.add(ma);
			}
		}catch(SQLException e) {
			System.err.println(e);
			
		}
		return produtos;
	}
	

	public OrigemProduto buscarOrigem(int id) throws Exception{
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = Connect.toConnect();
		
		try {
			stmt = conn.prepareStatement("select nomeOrigemProduto from origemproduto where idOrigemProduto = '" + id + "';");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				OrigemProduto op = new OrigemProduto();
				op.setOrigemProduto(rs.getString("nomeOrigemProduto"));
				return op;
			}
		}catch(Exception e) {
			System.err.println(e);
		}
		return null;
		
	}
	
	public StatusProduto buscarStatus(int id) throws Exception{
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = Connect.toConnect();
		
		try {
			stmt = conn.prepareStatement("select nomeStatusProduto from statusproduto where idStatusProduto = '" + id + "';");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				StatusProduto op = new StatusProduto();
				op.setStatusProduto(rs.getString("nomeStatusProduto"));
				return op;
			}
		}catch(Exception e) {
			System.err.println(e);
		}
		return null;
		
	}
	
	public TipoProduto buscarTipo(int id) throws Exception{
			
			ResultSet rs = null;
			PreparedStatement stmt = null;
			Connection conn = Connect.toConnect();
			
			try {
				stmt = conn.prepareStatement("select nomeTipoProduto from tipoproduto where idTipoProduto = '" + id + "';");
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					TipoProduto op = new TipoProduto();
					op.setNomeTipoProduto(rs.getString("nomeTipoProduto"));
					return op;
				}
			}catch(Exception e) {
				System.err.println(e);
			}
			return null;
			
		}
public int buscaIdOrigemProduto(String origem) throws Exception{
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		OrigemProduto op = new OrigemProduto();
		Connection conn = Connect.toConnect();
				
		try {
			stmt = conn.prepareStatement("select idOrigemProduto from origemProduto where nomeOrigemProduto = '" + origem + "';\r\n");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				op.setIdOrigemProduto(rs.getInt("idOrigemProduto"));
			}

		}catch(SQLException e) {
			System.err.println(e);
			System.out.println("aqui");
		}catch(Exception e) {
			System.err.println(e);
		}
		return op.getIdOrigemProduto();
	}
	
	public int buscaIdStatusProduto(String status) throws Exception{
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		StatusProduto sp = new StatusProduto();
		Connection conn = Connect.toConnect();
				
		try {
			
			stmt = conn.prepareStatement("select idStatusProduto from statusProduto where nomeStatusProduto = '" + status + "';\r\n");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				sp.setIdStatusProduto(rs.getInt("idStatusProduto"));
			}
			
		}catch(SQLException e) {
			System.err.println(e);
			
		}
		return sp.getIdStatusProduto();
	}
	
	public int buscaIdTipoProduto(String tipo) throws Exception{
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		TipoProduto tp = new TipoProduto();
		Connection conn = Connect.toConnect();
				
		try {
			
			stmt = conn.prepareStatement("select idTipoProduto from tipoProduto where nomeTipoProduto = '" + tipo + "';\r\n");
			rs = stmt.executeQuery();
			while(rs.next()) {
				tp.setIdTipoProduto(rs.getInt("idTipoProduto"));
			}
			
		}catch(SQLException e) {
			System.err.println(e);
			
		}
		return tp.getIdTipoProduto();
	}
	
	public int buscaIdFornecedor(String fornecedor) throws Exception{
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Fornecedor tp = new Fornecedor();
		Connection conn = Connect.toConnect();
				
		try {
			
			stmt = conn.prepareStatement("select idFornecedor from fornecedor where CNPJ = '" + fornecedor + "';\r\n");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				tp.setIdFornecedor(rs.getInt("idFornecedor"));
			}
			
		}catch(SQLException e) {
			System.err.println(e);
			
		}
		return tp.getIdFornecedor();
	}
}

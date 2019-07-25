package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.Connect;
import unioeste.geral.produto.Produto;
import unioeste.gestão.UC_buscaProduto.UC_BuscaProduto;
import unioeste.gestão.UC_editarProduto.UC_EditarProduto;
import unioeste.gestão.UC_inserirProduto.UC_InserirProduto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub;
		List <Produto> a = new ArrayList<>();
		try {
			UC_InserirProduto x = new UC_InserirProduto();
			//x.inserirProduto("caroline",52.0 ,10.0, "Amazonia", "Disponivel", "Perfume", "1064587545");
			
			UC_EditarProduto y = new UC_EditarProduto();
			y.EditarProduto(49, "Descontinuado", 55.0);
			
			UC_BuscaProduto z = new UC_BuscaProduto();
			a = z.buscaProdutos("Kaiak");
			
			for (int i = 0; i < a.size(); i++) {
				imprimirproduto(a.get(i));
			}
			
			mostrarProdutos();
			mostrarProdutos();
		}catch(Exception e) {
			System.out.println(e);
		}

	}
	
	public static void imprimirproduto(Produto p) throws Exception{
		
		
			System.out.println("Nome: " + p.getNomeProduto());
			System.out.println("Valor: " + p.getValorVenda());
		
	}
	
	public static void mostrarProdutos() throws Exception{
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection conn = Connect.toConnect();
		
		List<Produto> produtos = new ArrayList<>();
		UC_BuscaProduto bp = new UC_BuscaProduto();
		
		try {
			
			stmt = conn.prepareStatement("select * from produto;");
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				Produto ma = new Produto();
				ma.setIdProduto(rs.getInt("idProduto"));
				ma.setNomeProduto(rs.getString("nomeProduto"));
				ma.setValorVenda(rs.getDouble("valorVenda"));
				ma.setValorCusto(rs.getDouble("valorCusto"));
				ma.setIdOrigemProduto(bp.buscarOrigem(rs.getInt("idOrigemProduto")));
				ma.setIdStatusProduto(bp.buscarStatus(rs.getInt("idStatusProduto")));
				ma.setIdTipoProduto(bp.buscarTipo(rs.getInt("idTipoProduto")));
				produtos.add(ma);
			}
			
			for (int i = 0; i < produtos.size(); i++) {
				System.out.println(produtos.get(i).getIdProduto());
				System.out.println(produtos.get(i).getNomeProduto());
				System.out.println(produtos.get(i).getValorVenda());
				System.out.println(produtos.get(i).getValorCusto());
				System.out.println(produtos.get(i).getIdOrigemProduto());
				System.out.println(produtos.get(i).getIdStatusProduto());
				System.out.println(produtos.get(i).getIdTipoProduto());
				System.out.println();
			}
		}catch(SQLException e) {
			System.err.println(e);
			
		}

	}
}

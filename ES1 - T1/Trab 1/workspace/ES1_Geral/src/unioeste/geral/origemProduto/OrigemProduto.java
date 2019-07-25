package unioeste.geral.origemProduto;

public class OrigemProduto {

	private int idOrigemProduto;
	private String origemProduto;
	
	public int getIdOrigemProduto() {
		return idOrigemProduto;
	}
	public void setIdOrigemProduto(int idOrigemProduto) {
		this.idOrigemProduto = idOrigemProduto;
	}
	public String getOrigemProduto() {
		return origemProduto;
	}
	public void setOrigemProduto(String origemProduto) {
		this.origemProduto = origemProduto;
	}
	
	public String toString() {
		return "Origem do produto: " + this.origemProduto;
	}
}

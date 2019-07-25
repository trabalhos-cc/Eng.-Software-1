package unioeste.geral.statusProduto;

public class StatusProduto {

	private int idStatusProduto;
	private String statusProduto;
	
	public int getIdStatusProduto() {
		return idStatusProduto;
	}
	public void setIdStatusProduto(int idStatusProduto) {
		this.idStatusProduto = idStatusProduto;
	}
	public String getStatusProduto() {
		return statusProduto;
	}
	public void setStatusProduto(String statusProduto) {
		this.statusProduto = statusProduto;
	}
	
	public String toString () {
		return "Status do Produto: " + this.statusProduto;
	}
}

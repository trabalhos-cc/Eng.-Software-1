package unioeste.geral.tipoProduto;

public class TipoProduto {

	private int idTipoProduto;
	private String nomeTipoProduto;
	
	public int getIdTipoProduto() {
		return idTipoProduto;
	}
	public void setIdTipoProduto(int idTipoProduto) {
		this.idTipoProduto = idTipoProduto;
	}
	public String getNomeTipoProduto() {
		return nomeTipoProduto;
	}
	public void setNomeTipoProduto(String nomeTipoProduto) {
		this.nomeTipoProduto = nomeTipoProduto;
	}
	
	public String toString() {
		return "Tipo do Produto: " + this.nomeTipoProduto;
	}
}

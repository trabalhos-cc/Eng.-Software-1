package connectAll;

public class manipProduto {

	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}
	public float getValorCusto() {
		return valorCusto;
	}
	public void setValorCusto(float valorCusto) {
		this.valorCusto = valorCusto;
	}
	public String getOrigemProduto() {
		return origemProduto;
	}
	public void setOrigemProduto(String origemProduto) {
		this.origemProduto = origemProduto;
	}
	public String getStatusProduto() {
		return statusProduto;
	}
	public void setStatusProduto(String statusProduto) {
		this.statusProduto = statusProduto;
	}
	public String getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	public int getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(int fornecedor) {
		this.fornecedor = fornecedor;
	}
	private float valorVenda;
	private float valorCusto;
	private String origemProduto;
	private String statusProduto;
	private String tipoProduto;
	private int fornecedor;
}

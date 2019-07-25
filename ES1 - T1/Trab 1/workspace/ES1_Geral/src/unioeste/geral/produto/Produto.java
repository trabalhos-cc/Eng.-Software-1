package unioeste.geral.produto;

import unioeste.geral.fornecedor.Fornecedor;
import unioeste.geral.origemProduto.OrigemProduto;
import unioeste.geral.statusProduto.StatusProduto;
import unioeste.geral.tipoProduto.TipoProduto;

public class Produto {

	private int idProduto;
	private String nomeProduto;
	private Double valorVenda;
	private Double valorCusto;
	
	private OrigemProduto idOrigemProduto;
	private StatusProduto idStatusProduto;
	private TipoProduto idTipoProduto;
	private Fornecedor idFornecedor;
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public Double getValorCusto() {
		return valorCusto;
	}
	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}
	public OrigemProduto getIdOrigemProduto() {
		return idOrigemProduto;
	}
	public void setIdOrigemProduto(OrigemProduto idOrigemProduto) {
		this.idOrigemProduto = idOrigemProduto;
	}
	public StatusProduto getIdStatusProduto() {
		return idStatusProduto;
	}
	public void setIdStatusProduto(StatusProduto idStatusProduto) {
		this.idStatusProduto = idStatusProduto;
	}
	public TipoProduto getIdTipoProduto() {
		return idTipoProduto;
	}
	public void setIdTipoProduto(TipoProduto idTipoProduto) {
		this.idTipoProduto = idTipoProduto;
	}
	public Fornecedor getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(Fornecedor idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
	
	
}

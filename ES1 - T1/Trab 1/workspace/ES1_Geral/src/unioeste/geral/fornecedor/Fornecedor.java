package unioeste.geral.fornecedor;

public class Fornecedor {

	private int idFornecedor;
	private String nomeFornecedor;
	private int CNPJ;
	private int numeroComercial;
	private String complemento;
	private int idEndereco;
	
	
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public int getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(int cNPJ) {
		CNPJ = cNPJ;
	}
	public int getNumeroComercial() {
		return numeroComercial;
	}
	public void setNumeroComercial(int numeroComercial) {
		this.numeroComercial = numeroComercial;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getEndereco() {
		return idEndereco;
	}
	public void setEndereco(int endereco) {
		this.idEndereco = endereco;
	}
	
	public String tiString() {
		return "Nome do fornecedor: " + this.nomeFornecedor;
	}
}

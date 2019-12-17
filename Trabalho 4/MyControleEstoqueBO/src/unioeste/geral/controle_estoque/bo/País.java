package unioeste.geral.controle_estoque.bo;

import java.io.Serializable;

public class Pa�s implements Serializable{

	public Pa�s(int idPais, String nomePa�s) {
		super();
		this.idPais = idPais;
		this.nomePa�s = nomePa�s;
	}

	/**
	 *  Vers�o da UID auto-gerada pela classe;
	 */
	private static final long serialVersionUID = -7128130617857365632L;

	private int idPais;
	private String nomePa�s;

	public String getNomePa�s() {
		return nomePa�s;
	}

	public void setNomePa�s(String nomePa�s) {
		this.nomePa�s = nomePa�s;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
}

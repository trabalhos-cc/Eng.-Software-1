package unioeste.geral.controle_estoque.bo;

import java.io.Serializable;

public class UF implements Serializable{

	public UF(int idUF, String nomeUF, unioeste.geral.controle_estoque.bo.Pa�s pa�s) {
		super();
		this.idUF = idUF;
		this.nomeUF = nomeUF;
		Pa�s = pa�s;
	}
	/**
	 * Vers�o da UID auto-gerada pela classe;
	 */
	private static final long serialVersionUID = 1893719978134227073L;

	private int idUF;
	private String nomeUF;
	private Pa�s Pa�s;
	
	public String getNomeUF() {
		return nomeUF;
	}
	public void setNomeUF(String nomeUF) {
		this.nomeUF = nomeUF;
	}
	public Pa�s getPa�s() {
		return Pa�s;
	}
	public void setPa�s(Pa�s pa�s) {
		Pa�s = pa�s;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getIdUF() {
		return idUF;
	}
	public void setIdUF(int idUF) {
		this.idUF = idUF;
	}
}

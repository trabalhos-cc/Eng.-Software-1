package unioeste.geral.homebank.bo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sexo {
	
	private String Descricao;
	private char Sigla;
	
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public char getSigla() {
		return Sigla;
	}
	public void setSigla(char sigla) {
		Sigla = sigla;
	}
}

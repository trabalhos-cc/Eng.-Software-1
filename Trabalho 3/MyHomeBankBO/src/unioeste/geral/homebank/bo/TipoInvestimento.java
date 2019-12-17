package unioeste.geral.homebank.bo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TipoInvestimento {

	private int idTipoInvestimento;
	private String nomeTipoInvestimento;
	
	public int getIdTipoInvestimento() {
		return idTipoInvestimento;
	}
	public void setIdTipoInvestimento(int idTipoInvestimento) {
		this.idTipoInvestimento = idTipoInvestimento;
	}
	public String getNomeTipoInvestimento() {
		return nomeTipoInvestimento;
	}
	public void setNomeTipoInvestimento(String nomeTipoInvestimento) {
		this.nomeTipoInvestimento = nomeTipoInvestimento;
	}	
}

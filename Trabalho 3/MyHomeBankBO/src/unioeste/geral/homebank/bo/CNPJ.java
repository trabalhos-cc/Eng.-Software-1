package unioeste.geral.homebank.bo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CNPJ {
	
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}

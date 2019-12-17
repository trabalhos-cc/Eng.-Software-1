package unioeste.geral.homebank.bo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CPF {
	private String CPF;

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
}

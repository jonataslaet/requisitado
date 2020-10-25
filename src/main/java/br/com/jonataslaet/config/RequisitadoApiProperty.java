package br.com.jonataslaet.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class RequisitadoApiProperty {

	private String originPermitida = "http://localhost:4200";
	
	public String getOriginPermitida() {
		return originPermitida;
	}
	
	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}
	
}

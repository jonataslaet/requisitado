package br.com.jonataslaet.controller.erro;

import org.springframework.http.HttpStatus;

public class Erro {
	private String mensagem;
	private HttpStatus statusHttp;

	public Erro(String mensagem, HttpStatus httpStatus) {
		this.mensagem = mensagem;
		this.statusHttp = httpStatus;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public HttpStatus getStatusHttp() {
		return statusHttp;
	}

	public void setStatusHttp(HttpStatus statusHttp) {
		this.statusHttp = statusHttp;
	}
	
}

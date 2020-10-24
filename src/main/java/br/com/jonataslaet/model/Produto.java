package br.com.jonataslaet.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Produto {
	private Long id;
	
	@NotBlank(message = "O campo nome é obrigatório")
	@Size(min=5, max=50)
	private String nome;

	public Produto(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

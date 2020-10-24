package br.com.jonataslaet.service;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jonataslaet.controller.erro.ObjectNotFoundException;
import br.com.jonataslaet.model.Produto;
import br.com.jonataslaet.repository.DataBase;

@Service
public class ProdutoService {

	public static DataBase db = new DataBase(true);
	
	public ResponseEntity<?> buscarProdutos(){
		return ResponseEntity.ok(DataBase.getProdutos());
	}
	
	// Retorna um produto específico
	public ResponseEntity<?> buscarProduto(Long id) {
		for (Produto p : DataBase.getProdutos()) {
			if (p.getId() == id) {
				return ResponseEntity.ok(p);
			}
		}
		throw new ObjectNotFoundException("O produto não foi encontrado");
	}
	
	// Cadastra um novo produto
	public ResponseEntity<?> cadastrarProduto(Produto produtoNovo) {
		
		DataBase.getProdutos().add(produtoNovo);
		
		// Gera o link do novo produto adicionado
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produtoNovo.getId())
				.toUri();

		// Envia na resposta o código de criação e no header envie o link gerado do novo
		// produto
		return ResponseEntity.created(location).body(produtoNovo);
	}
}

package br.com.jonataslaet.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}

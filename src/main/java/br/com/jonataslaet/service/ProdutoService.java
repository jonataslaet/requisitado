package br.com.jonataslaet.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jonataslaet.repository.DataBase;

@Service
public class ProdutoService {

	public static DataBase db = new DataBase(true);
	
	public ResponseEntity<?> buscarProdutos(){
		return ResponseEntity.ok(DataBase.getProdutos());
	}
	
}

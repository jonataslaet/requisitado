package br.com.jonataslaet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonataslaet.service.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService ps;
	
	@GetMapping
	public ResponseEntity<?> buscarTodosProdutos(){
		return ps.buscarProdutos();
	}
}

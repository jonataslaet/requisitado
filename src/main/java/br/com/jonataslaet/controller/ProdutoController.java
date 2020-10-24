package br.com.jonataslaet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonataslaet.model.Produto;
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
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<?> buscarProduto(@PathVariable Long id){
		return ps.buscarProduto(id);
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrarProduto(@RequestBody @Valid Produto produtoNovo){
		return ps.cadastrarProduto(produtoNovo);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado){
		return ps.atualizarProduto(id, produtoAtualizado);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> deletarProduto(@PathVariable Long id){
		return ps.deletarProduto(id);
	}
}

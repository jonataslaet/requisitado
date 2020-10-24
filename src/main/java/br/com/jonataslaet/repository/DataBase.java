package br.com.jonataslaet.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.jonataslaet.model.Produto;

public class DataBase {
	private static List<Produto> produtos = new ArrayList<>();
	private boolean iniciaLista = false;
	
	public DataBase(boolean iniciaLista) {
		this.setIniciaLista(iniciaLista);
		if (iniciaLista) {
			iniciaListaDeProdutos();
			this.iniciaLista = false;
		}
	}

	public static void iniciaListaDeProdutos() {
		Produto p1 = new Produto(1L, "TV LCD 50 Polegadas");
		Produto p2 = new Produto(2L, "Suporte para Notebook");
		Produto p3 = new Produto(3L, "Fone de Ouvido Bluetooth");
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);
	}

	public static List<Produto> getProdutos() {
		return produtos;
	}

	public static void setProdutos(List<Produto> produtosInseridos) {
		produtos = produtosInseridos;
	}

	public boolean isIniciaLista() {
		return iniciaLista;
	}

	public void setIniciaLista(boolean iniciaLista) {
		this.iniciaLista = iniciaLista;
	}
}

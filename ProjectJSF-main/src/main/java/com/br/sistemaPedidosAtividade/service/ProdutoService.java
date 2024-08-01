package com.br.sistemaPedidosAtividade.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.sistemaPedidosAtividade.model.Produto;
import com.br.sistemaPedidosAtividade.repository.ProdutoRepository;
import com.br.sistemaPedidosAtividade.util.Transacional;

public class ProdutoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRepository produtoRepository;

	@Transacional
	public void salvar(Produto produto) {
		produtoRepository.guardar(produto);
	}

	@Transacional
	public void excluir(Produto produto) {
		produtoRepository.remover(produto);
	}

	public void findById(Long id) {
		produtoRepository.buscarPorId(id);
	}

}

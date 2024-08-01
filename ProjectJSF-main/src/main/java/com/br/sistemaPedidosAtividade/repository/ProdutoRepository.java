package com.br.sistemaPedidosAtividade.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.br.sistemaPedidosAtividade.model.Produto;

public class ProdutoRepository implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public ProdutoRepository() {

	}

	public ProdutoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Produto buscarPorId(Long id) {
		return manager.find(Produto.class, id);
	}

	public List<Produto> pesquisar(String nome) {
		String jpql = "from Produto where nome like :nome";

		TypedQuery<Produto> query = manager.createQuery(jpql, Produto.class);

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

	public List<Produto> findAll() {
		return manager.createQuery("from Produto", Produto.class).getResultList();
	}

	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}

	public void remover(Produto produto) {
		produto = buscarPorId(produto.getId());
		manager.remove(produto);
	}
}

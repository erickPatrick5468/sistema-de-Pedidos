package com.br.sistemaPedidosAtividade.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.br.sistemaPedidosAtividade.model.Usuario;

public class UsuarioRepository implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public UsuarioRepository() {

	}

	public UsuarioRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Usuario buscarPorId(Long id) {
		return manager.find(Usuario.class, id);
	}

	public List<Usuario> pesquisar(String nome) {
		String jpql = "from Usuario where nome like :nome";

		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);

		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();
	}

	public Usuario autenticar(String email, String senha) {
		TypedQuery<Usuario> query = manager
				.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Usuario.class);
		query.setParameter("email", email);
		query.setParameter("senha", senha);

		return query.getSingleResult();
	}

	public List<Usuario> findAll() {
		return manager.createQuery("from Usuario", Usuario.class).getResultList();
	}

	public Usuario guardar(Usuario usuario) {
		return manager.merge(usuario);
	}

	public void remover(Usuario usuario) {
		usuario = buscarPorId(usuario.getId());
		manager.remove(usuario);
	}

}

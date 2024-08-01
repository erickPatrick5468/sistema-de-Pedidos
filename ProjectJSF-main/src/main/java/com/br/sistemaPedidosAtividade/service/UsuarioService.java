package com.br.sistemaPedidosAtividade.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.br.sistemaPedidosAtividade.model.Usuario;
import com.br.sistemaPedidosAtividade.repository.UsuarioRepository;
import com.br.sistemaPedidosAtividade.util.Transacional;

public class UsuarioService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Transacional
	public void salvar(Usuario usuario) {
		usuarioRepository.guardar(usuario);
	}

	@Transacional
	public void excluir(Usuario usuario) {
		usuarioRepository.remover(usuario);
	}

	public Usuario findById(Long id) {
		return usuarioRepository.buscarPorId(id);
	}

	public Usuario autenticar(String email, String senha) {
		Usuario usuario = usuarioRepository.autenticar(email, senha);
		return usuario;
	}
}

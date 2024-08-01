package com.br.sistemaPedidosAtividade.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.br.sistemaPedidosAtividade.model.TipoUsuario;
import com.br.sistemaPedidosAtividade.model.Usuario;
import com.br.sistemaPedidosAtividade.repository.UsuarioRepository;
import com.br.sistemaPedidosAtividade.service.UsuarioService;
import com.br.sistemaPedidosAtividade.util.FacesMessages;

@Named
@ViewScoped
public class ListarUsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioRepository;

	private List<Usuario> listaUsuario;

	private String termoPesquisa;

	@Inject
	private FacesMessages messages;

	@Inject
	private UsuarioService usuarioService;

	private Usuario usuario = new Usuario();

	public void prepararNovoUsuario() {
		usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public TipoUsuario[] getTipoUsuario() {
		return TipoUsuario.values();
	}

	private boolean isExistsearch() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
	}
	
	public boolean isUsuarioSelecionado() {
		return usuario != null && usuario.getId() != null;
	}
	
	public void atualizarRegistrosTable() {
		if (isExistsearch()) {
			pesquisar();
		}else {
			findAll();
		}
	}

	public void salvar() {
		usuarioService.salvar(usuario);
		
		atualizarRegistrosTable();

		messages.info("Usuario salvo com sucesso!");

		// Atualizar os componentes especificando cada ID corretamente
		RequestContext.getCurrentInstance()
			.update(Arrays.asList("frm:usuarioDataTable", "frm:messages"));
		//RequestContext.getCurrentInstance().update("frm:messages");
	}

	public void pesquisar() {
		listaUsuario = usuarioRepository.pesquisar(termoPesquisa);
		if (listaUsuario.isEmpty()) {
			messages.info("Sua consulta não retornou registro!");
		}
	}

	public void findAll() {
		listaUsuario = usuarioRepository.findAll();
	}
	
	public void excluir() {
		usuarioService.excluir(usuario);	
		usuario = null;
		atualizarRegistrosTable();
		messages.info("Usuario Excluido Com Sucesso!");
	}
}

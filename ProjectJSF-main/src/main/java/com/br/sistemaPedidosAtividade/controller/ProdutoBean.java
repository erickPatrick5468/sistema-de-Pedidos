package com.br.sistemaPedidosAtividade.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.br.sistemaPedidosAtividade.model.Produto;
import com.br.sistemaPedidosAtividade.repository.ProdutoRepository;
import com.br.sistemaPedidosAtividade.service.ProdutoService;
import com.br.sistemaPedidosAtividade.util.FacesMessages;

@Named
@ViewScoped
public class ProdutoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRepository produtoRepository;

	private List<Produto> listaProduto;

	private String termoPesquisa;

	@Inject
	private FacesMessages messages;

	@Inject
	private ProdutoService produtoService;

	private Produto produto = new Produto();

	public void prepararNovoProduto() {
		produto = new Produto();
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	private boolean isExistsearch() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
	}
	
	public boolean isProdutoSelecionado() {
		return produto != null && produto.getId() != null;
	}
	
	public void atualizarRegistrosTable() {
		if (isExistsearch()) {
			pesquisar();
		}else {
			findAll();
		}
	}

	public void salvar() {
		
//		 try {
//		        // Certifique-se de que vendedorId está atribuído
//		        if (vendedorId != null) {
//		            produto.setVendedorId(produtoRepository.buscarPorId(vendedorId));
//		        } else {
//		            FacesContext.getCurrentInstance().addMessage(termoPesquisa, null);
//		            return;
//		        }
//		        produtoRepository.guardar(produto);
//		        listaProduto = produtoRepository.findAll();
//		        messages.info("Produto salvo com sucesso!");
//		    } catch (Exception e) {
//		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar o produto", e.getMessage()));
//		    }
//		
		produtoService.salvar(produto);
		
		atualizarRegistrosTable();

		messages.info("Produto salvo com sucesso!");

		// Atualizar os componentes especificando cada ID corretamente
		RequestContext.getCurrentInstance()
			.update(Arrays.asList("frm:produtoDataTable", "frm:messages"));
		//RequestContext.getCurrentInstance().update("frm:messages");
	}

	public void pesquisar() {
		listaProduto = produtoRepository.pesquisar(termoPesquisa);
		if (listaProduto.isEmpty()) {
			messages.info("Sua consulta não retornou registro!");
		}
	}

	public void findAll() {
		listaProduto = produtoRepository.findAll();
	}
	
	public void excluir() {
		produtoService.excluir(produto);	
		produto = null;
		atualizarRegistrosTable();
		messages.info("Produto Excluido Com Sucesso!");
	}
}

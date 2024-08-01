package com.br.sistemaPedidosAtividade.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.br.sistemaPedidosAtividade.model.Pedido;

@ManagedBean
@ViewScoped
public class PedidoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Pedido pedido;
	private List<Pedido> pedidos;

	// getters e setters

	public void realizarPedido() {
		// lógica de realização de pedido
	}

	public List<Pedido> listarPedidos() {
		// lógica de listagem de pedidos
		return pedidos;
	}
}

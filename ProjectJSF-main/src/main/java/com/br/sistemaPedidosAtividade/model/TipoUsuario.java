package com.br.sistemaPedidosAtividade.model;

public enum TipoUsuario {
	VENDEDOR("VENDEDOR"), 
	COMPRADOR("COMPRADOR"), 
	ADMINISTRADOR("ADMINISTRADOR");

	private String descricao;

	TipoUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}

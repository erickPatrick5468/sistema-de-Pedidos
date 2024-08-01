package com.br.sistemaPedidosAtividade.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.br.sistemaPedidosAtividade.model.Usuario;

public class VendedorConverter implements Converter {

	private List<Usuario> listaUsuarioVendedor;

	public VendedorConverter(List<Usuario> listaUsuarioVendedor) {
		this.listaUsuarioVendedor = listaUsuarioVendedor;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}

		Long id = Long.valueOf(value);

		for (Usuario usuarioVendedor : listaUsuarioVendedor) {
			if (id.equals(usuarioVendedor.getId())) {
				return usuarioVendedor.getId();
			}
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}

		Usuario usuarioVendedor = (Usuario) value;

		return usuarioVendedor.getId().toString();
	}
}

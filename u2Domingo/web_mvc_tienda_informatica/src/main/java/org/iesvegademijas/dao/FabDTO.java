package org.iesvegademijas.dao;

import java.util.Optional;

import org.iesvegademijas.model.Fabricante;

public class FabDTO extends Fabricante {
	private Integer numProductos;
	
	public FabDTO() {
		 super();
	}
	
	public FabDTO(Fabricante fab) {
		 super();
	}

	public Integer getNumProductos() {
		return numProductos;
	}

	public void setNumProductos(Integer numProductos) {
		this.numProductos = numProductos;
	}

	@Override
	public String toString() {
		return "FabDTO [numProductos=" + numProductos + "]";
	}
	
}

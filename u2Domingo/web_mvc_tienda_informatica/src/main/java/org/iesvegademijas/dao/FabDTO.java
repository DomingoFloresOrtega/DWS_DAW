package org.iesvegademijas.dao;

import java.util.Optional;

import org.iesvegademijas.model.Fabricante;

public class FabDTO extends Fabricante {
	private Optional<Integer> numProductos;
	
	public FabDTO(Fabricante fab) {
		 super();
	}

	public Optional<Integer> getNumProductos() {
		return numProductos;
	}

	public void setNumProductos(Optional<Integer> numProductos) {
		this.numProductos = numProductos;
	}

	@Override
	public String toString() {
		return "FabDTO [numProductos=" + numProductos + "]";
	}
	
}

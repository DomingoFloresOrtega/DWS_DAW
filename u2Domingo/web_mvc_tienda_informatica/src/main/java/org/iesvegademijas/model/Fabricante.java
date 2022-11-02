package org.iesvegademijas.model;

public class Fabricante {

	private int codigo;
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
	
}

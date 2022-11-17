package org.iesvegademijas.model;

import java.util.Objects;

public class Producto {
	private int codigo;
	private String nombre;
	private Double precio;
	private int codigoFabricante;
	private String nombre_fab;
	
	
	public Producto() {
		super();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getCodigoFabricante() {
		return codigoFabricante;
	}
	public void setCodigoFabricante(int codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}

	public String getNombre_fab() {
		return nombre_fab;
	}

	public void setNombre_fab(String nombre_fab) {
		this.nombre_fab = nombre_fab;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, codigoFabricante, nombre, nombre_fab, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return codigo == other.codigo && codigoFabricante == other.codigoFabricante
				&& Objects.equals(nombre, other.nombre) && Objects.equals(nombre_fab, other.nombre_fab)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", codigoFabricante="
				+ codigoFabricante + ", nombre_fab=" + nombre_fab + "]";
	}
	
}

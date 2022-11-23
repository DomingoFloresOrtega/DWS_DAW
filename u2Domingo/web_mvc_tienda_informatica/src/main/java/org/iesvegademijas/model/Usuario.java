package org.iesvegademijas.model;

import java.util.Objects;

public class Usuario {
	private int codigo;
	private String user;
	private String pass;
	private String rol;
	
	public Usuario() {
		super();
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, pass, rol, user);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return codigo == other.codigo && Objects.equals(pass, other.pass) && Objects.equals(rol, other.rol)
				&& Objects.equals(user, other.user);
	}
	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", user=" + user + ", pass=" + pass + ", rol=" + rol + "]";
	}
}

package examen.domingo.model;

public class Empleado {
	private int codigo;
	private String nif;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int cod_dept;
	
	public Empleado() {
		super();
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNif() {
		return nif;
	}
	
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public int getCod_dept() {
		return cod_dept;
	}
	
	public void setCod_dept(int cod_dept) {
		this.cod_dept = cod_dept;
	}
	
	
}

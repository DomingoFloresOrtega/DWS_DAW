package examen.domingo.dao;

import java.util.Optional;

import examen.domingo.model.Departamento;

public class DepDTO extends Departamento {
	private Integer numEmpleados;
	
	public DepDTO() {
		 super();
	}
	
	public DepDTO(Departamento dep) {
		 super();
	}

	public Integer getNumEmpleados() {
		return numEmpleados;
	}

	public void setNumEmpleados(Integer numEmpleados) {
		this.numEmpleados = numEmpleados;
	}

	@Override
	public String toString() {
		return "DepDTO [numProductos=" + numEmpleados + "]";
	}
	
}

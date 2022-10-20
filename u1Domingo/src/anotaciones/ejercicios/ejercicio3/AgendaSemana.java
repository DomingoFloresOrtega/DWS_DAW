package anotaciones.ejercicios.ejercicio3;

import java.util.ArrayList;
import java.util.List;

import anotaciones.ejercicios.ejercicio2.Empleado;
import anotaciones.ejercicios.ejercicio2.EmpleadoAnotacion;
import anotaciones.ejercicios.ejercicio2.Empresa;

public class AgendaSemana {
	List<Tarea> agenda;

	public AgendaSemana() {
		this.agenda = new ArrayList<>();
	}

	public List<Tarea> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Tarea> agenda) {
		this.agenda = agenda;
	}
	
	public void aniadirTarea(Tarea t) {
		this.agenda.add(t);
	}

	public void mostrarTareas() {
		for (Tarea a : agenda) {
			System.out.println("Nombre: " + a.getTituloTarea());
		}
	}
	
	public static AgendaSemana cargadorContexto() {
		
		AgendaSemana ag = new AgendaSemana();
		
		TareaAnotacion[] tareaAno = AgendaSemana.class.getAnnotationsByType(TareaAnotacion.class);
		
		for (TareaAnotacion tarea : tareaAno) {
			Tarea tareas = new Tarea();
			tareas.setTituloTarea(tarea.tituloTarea());
			tareas.setDescripcion(tarea.descripcion());
			tareas.setDiaSemana(tarea.diaSemana());
			tareas.setHoraSemana(tarea.horaSemana());
			ag.aniadirTarea(tareas);
		}
		
		
		
		return ag;
	}
	
	public static void main(String[] args) {
		AgendaSemana agenda = AgendaSemana.cargadorContexto();
		
	}
}

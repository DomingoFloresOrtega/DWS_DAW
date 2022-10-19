package anotaciones.ejercicios.ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@EmpleadoAnotacion(apellidos = "Ortegazo", clase = "Directivo", direccion = "C/ A", dni = "74859612", nombre = "o", telefono = "987654321")
@EmpleadoAnotacion(apellidos = "Ortega", clase = "Directivo", direccion = "C/ A", dni = "74859612", nombre = "Amancio", telefono = "987654321")
@EmpleadoAnotacion(apellidos = "Orteguita", clase = "Tecnico", direccion = "", dni = "", nombre = "Amancito", telefono = "", codTaller = 100)
@EmpleadoAnotacion(apellidos = "Orteguita", clase = "Oficial", direccion = "", dni = "", nombre = "Amancito", telefono = "", codTaller = 100)

public class Empresa {
	
	public static String DIRECTIVO = "Directivo";
	public static String TECNICO = "Tecnico";
	public static String OFICIAL = "Oficial";
	
	private String nombre;
	private List<Empleado> listaEmpleado;
	
	
	public Empresa() {
		this.listaEmpleado = new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Empleado> getListaEmpleado() {
		return listaEmpleado;
	}
	public void setListaEmpleado(List<Empleado> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}
	
	@Override
	public String toString() {
		for (Empleado empleado : listaEmpleado) {
			System.out.println("Nombre: " + empleado.getNombre() +
					", Apellidos: " + empleado.getApellidos() +
					", DNI: " + empleado.getDni() +
					", Telefono: " + empleado.getTelefono() +
					", Direccion: " + empleado.getDireccion());
		}
		
		return "";
	}

	public void aniadirEmpleado(Empleado empleado) {
		this.listaEmpleado.add(empleado);
	}
	
	public static Empresa cargadorContexto() {
		
		Empresa em = new Empresa();
		
		EmpleadoAnotacion[] empleadosAno = Empresa.class.getAnnotationsByType(EmpleadoAnotacion.class);
		
		for (EmpleadoAnotacion emAno : empleadosAno) {
			if (Empresa.DIRECTIVO.equals(emAno.clase())) {
				Directivo directivo = new Directivo();
				
				directivo.setNombre(emAno.nombre());
				directivo.setApellidos(emAno.apellidos());
				directivo.setDni(emAno.dni());
				directivo.setTelefono(emAno.telefono());
				directivo.setDireccion(emAno.direccion());
				directivo.setCodigoDespacho(emAno.codDespacho());
				em.aniadirEmpleado(directivo);
			} else if (Empresa.OFICIAL.equals(emAno.clase())) {
				Oficial oficial = new Oficial();
				
				oficial.setNombre(emAno.nombre());
				oficial.setApellidos(emAno.apellidos());
				oficial.setDni(emAno.dni());
				oficial.setTelefono(emAno.telefono());
				oficial.setDireccion(emAno.direccion());
				oficial.setCategoria(emAno.categoria());
				em.aniadirEmpleado(oficial);
			} else if (Empresa.TECNICO.equals(emAno.clase())) {
				Tecnico tecnico = new Tecnico();
				
				tecnico.setNombre(emAno.nombre());
				tecnico.setApellidos(emAno.apellidos());
				tecnico.setDni(emAno.dni());
				tecnico.setTelefono(emAno.telefono());
				tecnico.setDireccion(emAno.direccion());
				tecnico.setPerfil(emAno.perfil());
				em.aniadirEmpleado(tecnico);
			}
		}
		
		return em;
	}
	
	public static void main(String[] args) {
		Empresa empresa = Empresa.cargadorContexto();
		
		System.out.println(empresa.toString());
	}
	
	
}

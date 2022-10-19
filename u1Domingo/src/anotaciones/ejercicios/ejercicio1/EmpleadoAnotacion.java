package anotaciones.ejercicios.ejercicio1;

public @interface Empleado {
	
	String nombre();
	String apellidos();
	String dni();
	String direccion();
	String telefono();
	String clase();
	
	int codDespacho() default -1;
	int codTaller() default -1;
	String perfil() default "";
	String categoria() default "";
	
}

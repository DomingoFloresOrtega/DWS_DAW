package anotaciones.ejercicios.ejercicio2;

import java.lang.annotation.*;

@Repeatable(Empleados.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmpleadoAnotacion {
	
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

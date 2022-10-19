package anotaciones.ejercicios.ejercicio2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Empleados {
	EmpleadoAnotacion[] value();
}

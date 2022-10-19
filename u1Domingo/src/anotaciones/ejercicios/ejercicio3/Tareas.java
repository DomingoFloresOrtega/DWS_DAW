package anotaciones.ejercicios.ejercicio3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Tareas {
	TareaAnotacion[] value();
}

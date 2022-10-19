package anotaciones.ejercicios.ejercicio2;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Directivos.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface DirectivoAnotacion {
	EmpleadoAnotacion empAnota();
	int codigoDespacho() default -1;
}

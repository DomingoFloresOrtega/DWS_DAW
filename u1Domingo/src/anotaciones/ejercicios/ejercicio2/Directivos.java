package anotaciones.ejercicios.ejercicio2;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Directivos {
	DirectivoAnotacion[] value();
}

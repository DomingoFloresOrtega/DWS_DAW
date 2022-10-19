package anotaciones.ejercicios.ejercicio2;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Oficiales.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface OficialAnotacion {
	EmpleadoAnotacion empAnota();
	String categoria() default "";
}

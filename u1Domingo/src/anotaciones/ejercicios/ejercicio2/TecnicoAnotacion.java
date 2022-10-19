package anotaciones.ejercicios.ejercicio2;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Tecnicos.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface TecnicoAnotacion {
	EmpleadoAnotacion empAnota();
	String perfil() default "";
}

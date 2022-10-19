package anotaciones.ejercicios.ejercicio3;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import anotaciones.ejercicios.ejercicio2.Empleados;

@Repeatable(Tareas.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface TareaAnotacion {
	String tituloTarea() default "";
	String descripcion() default "";
	int diaSemana() default -1;
	double horaSemana() default -1;
}

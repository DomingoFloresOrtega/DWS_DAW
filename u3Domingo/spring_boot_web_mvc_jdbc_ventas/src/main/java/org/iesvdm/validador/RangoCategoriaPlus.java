package org.iesvdm.validador;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RangoCategoriaValidator.class)
@Documented
@Repeatable(org.iesvdm.validador.RangoCategoriaPlus.List.class)
public @interface RangoCategoriaPlus {
		
		//Campos adicionales de parámetros para la anotación
		int[] value() default 1;
			
		String message() default "ERROR";

		//Para validación en wizards, poco uso en la actualidad.
		Class<?>[] groups() default {};
		Class<? extends Payload>[] payload() default {};

		//Implementar el array que recoge la posible repetición de la anotación
		@Target(ElementType.FIELD)
		@Retention(RetentionPolicy.RUNTIME)
		@Documented
		@interface List {
			RangoCategoriaPlus[] value();
		}

}

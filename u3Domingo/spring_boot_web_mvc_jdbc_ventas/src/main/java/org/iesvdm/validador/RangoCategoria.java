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
@Repeatable(org.iesvdm.validador.RangoCategoria.List.class)
public @interface RangoCategoria {
	
		//Anotación de valor sobre enum ChequearNombreMode.BAJO, MEDIO o ALTO
		RangoCategoriaMode value() default RangoCategoriaMode.CIEN;
		
		//Campos adicionales de parámetros para la anotación
		int min() default 4;
		int max() default 100;
			
		String message() default "{error.chequearnombre.bajo}";

		//Para validación en wizards, poco uso en la actualidad.
		Class<?>[] groups() default {};
		Class<? extends Payload>[] payload() default {};

		//Implementar el array que recoge la posible repetición de la anotación
		@Target(ElementType.FIELD)
		@Retention(RetentionPolicy.RUNTIME)
		@Documented
		@interface List {
			RangoCategoria[] value();
		}

}

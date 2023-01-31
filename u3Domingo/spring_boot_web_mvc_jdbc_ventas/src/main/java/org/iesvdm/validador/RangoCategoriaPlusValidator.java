package org.iesvdm.validador;

import java.util.Iterator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangoCategoriaPlusValidator implements ConstraintValidator<RangoCategoriaPlus, Integer> {
	private int[] array;
    
    @Override
    public void initialize(RangoCategoriaPlus constraintAnnotation) {
       this.array = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer categoria, ConstraintValidatorContext constraintContext) {
       
    	String mensajeError = null;
    	
    	for (int i = 0; i < array.length; i++) {
    		if (categoria == array[i]) {
    			boolean isValid = true;
    		}
    	}
    	
    	boolean isValid = false;
        

        if ( !isValid ) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(mensajeError)
            .addConstraintViolation();
        }
        

        return isValid;
    }
}

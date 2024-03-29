package org.iesvdm.validador;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangoCategoriaValidator implements ConstraintValidator<RangoCategoria, Integer> {
	private int num;
    private int min;
    private int max;
    
    @Override
    public void initialize(RangoCategoria constraintAnnotation) {
       this.min = constraintAnnotation.min();
       this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer categoria, ConstraintValidatorContext constraintContext) {
       
    	String mensajeError = null;
    	if (categoria == 100 || categoria == 200 || categoria == 300 || categoria == 400
    			|| categoria == 500 || categoria == 600 || categoria == 700 || categoria == 800
    			|| categoria == 900 || categoria == 1000) {
    		boolean isValid = true;
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

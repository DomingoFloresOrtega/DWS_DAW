package org.iesvdm.validador;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangoCategoriaValidator implements ConstraintValidator<RangoCategoria, String> {
	private int num;
    private int min;
    private int max;
    
    @Override
    public void initialize(RangoCategoria constraintAnnotation) {
       this.min = constraintAnnotation.min();
       this.max = constraintAnnotation.max();
        
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
       
    	String mensajeError = null;
    	if (object != null) object = object.trim();
    	
    	boolean isValid = false;
        

        if ( !isValid ) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(mensajeError)
            .addConstraintViolation();
        }
        

        return isValid;
    }
}

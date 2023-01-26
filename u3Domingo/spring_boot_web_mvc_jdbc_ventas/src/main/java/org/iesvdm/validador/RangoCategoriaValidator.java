package org.iesvdm.validador;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangoCategoriaValidator implements ConstraintValidator<RangoCategoria, String> {
	
	private RangoCategoriaMode rangoCategoriaMode;
    private int min;
    private int max;
    
    @Override
    public void initialize(RangoCategoria constraintAnnotation) {
       this.rangoCategoriaMode = constraintAnnotation.value();
       this.min = constraintAnnotation.min();
       this.max = constraintAnnotation.max();
        
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
       
    	String mensajeError = null;
    	if (object != null) object = object.trim();
    	
    	boolean isValid = false;
        if ( rangoCategoriaMode == RangoCategoriaMode.CIEN ) {
            
        	 isValid = object != null 
        			 && !"".equals(object);
        	 
        	 if (!isValid) mensajeError = "{error.chequearnombre.bajo}";
 
        } else if( rangoCategoriaMode == RangoCategoriaMode.CIEN ) {
        	
        	isValid = object != null 
        			&& !"".equals(object) 
        			&& object.length() >= this.min;
        			
        	if (!isValid) mensajeError = "{error.chequearnombre.medio}";
        			
        } else if (rangoCategoriaMode == RangoCategoriaMode.CIEN) {
        	
        	isValid = object != null 
        			&& !"".equals(object) 
        			&& object.length() >= this.min
        			&& object.length() <= this.max;
        			
        	if (!isValid) mensajeError = "{error.chequearnombre.alto}";
        	
        }

        if ( !isValid ) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(mensajeError)
            .addConstraintViolation();
        }
        

        return isValid;
    }
}

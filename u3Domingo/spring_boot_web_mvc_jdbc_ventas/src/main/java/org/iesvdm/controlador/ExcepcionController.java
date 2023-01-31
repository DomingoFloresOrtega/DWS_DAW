package org.iesvdm.controlador;

import org.iesvdm.excepciones.MiExcepcion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcepcionController {
	
	@ExceptionHandler(MiExcepcion.class)
	public String handleAllUncaughtException(Model model, MiExcepcion exception) {
		
		model.addAttribute("traza", exception.getMessage());
		
		return "error";
		
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleAllUncaughtException(Model model, RuntimeException exception) {
		
		model.addAttribute("traza", exception.getMessage());
		
		return "error";
		
	}
}

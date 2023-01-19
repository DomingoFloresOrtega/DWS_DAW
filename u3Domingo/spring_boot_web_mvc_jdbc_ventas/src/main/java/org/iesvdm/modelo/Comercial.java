package org.iesvdm.modelo;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comercial {
	
	private int id;
	
	@NotBlank(message = "Por favor, introduzca nombre.")
	@Size(min=4, message = "{error.min}")
	@Size(max=30, message = "{error.max}")
	private String nombre;
	
	@NotBlank(message = "Por favor, introduzca apellido 1.")
	@Size(min=4, message = "{error.min}")
	@Size(max=30, message = "{error.max}")
	private String apellido1;
	private String apellido2;
	
	@DecimalMax(value="0.946", inclusive=true)
	@DecimalMin(value="0.276", inclusive=true)
	private BigDecimal comision;
}

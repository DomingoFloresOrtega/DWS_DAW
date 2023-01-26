package org.iesvdm.modelo;

import org.iesvdm.validador.RangoCategoria;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//La anotación @Data de lombok proporcionará el código de: 
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("unused")
public class Cliente {
	
	private int id;
	
	@NotBlank(message = "{error.nombre}")
	@Size(min=4, message = "{error.min}")
	@Size(max=30, message = "{error.max}")
	private String nombre;
	
	@NotBlank(message = "{error.ape1}")
	@Size(min=4, message = "{error.min}")
	@Size(max=30, message = "{error.max}")
	private String apellido1;
	private String apellido2;
	
	@NotBlank(message = "{error.ciudad}")
	@Size(min=4, message = "{error.min}")
	@Size(max=30, message = "{error.max}")
	private String ciudad;
	
	@NotNull(message = "{error.categoria}")
	@Min(value=100, message="{error.minCat}")
	@Max(value=1000, message="{error.maxCat}")
	@RangoCategoria()
	private int categoria;
	
}

package org.domingoe3.modelo;

import java.sql.Date;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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
public class Pelicula {
	
	private int id;
	
	@NotBlank(message = "{error.titulo}")
	@Size(min=3, message = "{error.min}")
	private String titulo;
	
	@Size(max=300, message = "{error.max}")
	private String descripcion;
	private int anio_lanzamiento;
	private int id_idioma;
	private int id_idioma_original;
	private int duracion_alquiler;
	
	@DecimalMin(value="0", inclusive=false)
	private double rental_rate;
	
	@DecimalMin(value="0", inclusive=false)
	private int duracion;
	
	@DecimalMin(value="19.99", inclusive=true)
	private double replacement_cost;
	private String clasificacion;
	private String caracteristicas_especiales;
	private Date ultima_actualizacion;
	
}

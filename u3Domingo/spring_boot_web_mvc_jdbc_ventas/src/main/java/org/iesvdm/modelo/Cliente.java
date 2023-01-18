package org.iesvdm.modelo;

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
	
	@NotBlank(message = "Por favor, introduzca nombre.")
	@Size(min=4, message = "Nombre al menos de 4 caracteres.")
	@Size(max=30, message = "Nombre como máximo de 30 caracteres.")
	private String nombre;
	
	@NotBlank(message = "Por favor, introduzca apellido 1.")
	@Size(min=4, message = "Apellido 1 al menos de 4 caracteres.")
	@Size(max=30, message = "Apellido 2 como máximo de 30 caracteres.")
	private String apellido1;
	private String apellido2;
	
	@NotBlank(message = "Por favor, introduzca ciudad.")
	@Size(min=4, message = "Ciudad al menos de 4 caracteres.")
	@Size(max=50, message = "Ciudad como máximo de 50 caracteres.")
	private String ciudad;
	
	@NotNull(message = "Por favor, introduzca categoria.")
	@Min(value=100, message="Categoria como minimo de 100 caracteres")
	@Max(value=1000, message="Categoria como maximo de 1000 caracteres")
	private int categoria;
	
}

package org.iesvdm.dto;

import org.iesvdm.validador.RangoCategoria;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteDTO {
	
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String ciudad;
	private int categoria;
	
	private int numPedTot;
	private int numPedTri;
	private int numPedSem;
	private int numPedAnu;
	private int numPedLus;
}

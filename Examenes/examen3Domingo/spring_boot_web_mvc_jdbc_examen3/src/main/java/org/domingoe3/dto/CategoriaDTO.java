package org.domingoe3.dto;

import java.util.Date;
import java.util.List;

import org.domingoe3.modelo.AlmacenCat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoriaDTO {
	
	private int id;
	private String nombre;
	public Date ultima_actualizacion;
	
	private int numPelTot;
	private List<AlmacenCat> numPelAlm;
}

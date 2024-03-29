package org.domingoe3.mapstruct;

import java.util.List;

import org.domingoe3.dto.CategoriaDTO;
import org.domingoe3.modelo.AlmacenCat;
import org.domingoe3.modelo.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
	
	@Mapping(target = "numPelTot",source = "numPelTot")
	@Mapping(target = "numPelAlm",source = "numPelAlm")
	public CategoriaDTO detalleADetalleDTO(Categoria categoria, int numPelTot, List<AlmacenCat> numPelAlm);
}

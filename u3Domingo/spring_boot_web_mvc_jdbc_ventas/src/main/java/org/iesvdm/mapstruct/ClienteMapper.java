package org.iesvdm.mapstruct;

import org.iesvdm.dto.ClienteDTO;
import org.iesvdm.modelo.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	
	@Mapping(target = "numPedTot",source = "numPedTot")
	@Mapping(target = "numPedTri",source = "numPedTri")
	@Mapping(target = "numPedSem",source = "numPedSem")
	@Mapping(target = "numPedAnu",source = "numPedAnu")
	@Mapping(target = "numPedLus",source = "numPedLus")
	public ClienteDTO detalleADetalleDTO(Cliente cliente, int numPedTot, int numPedTri, int numPedSem, int numPedAnu, int numPedLus);
}

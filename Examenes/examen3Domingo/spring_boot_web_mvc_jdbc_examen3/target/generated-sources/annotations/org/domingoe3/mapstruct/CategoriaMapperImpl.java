package org.domingoe3.mapstruct;

import java.util.Date;
import javax.annotation.processing.Generated;
import org.domingoe3.dto.CategoriaDTO;
import org.domingoe3.modelo.Categoria;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-03T11:22:48+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaDTO detalleADetalleDTO(Categoria categoria, int numPelTot, int numPelAlm) {
        if ( categoria == null ) {
            return null;
        }

        int id = 0;
        String nombre = null;
        Date ultima_actualizacion = null;
        if ( categoria != null ) {
            id = categoria.getId();
            nombre = categoria.getNombre();
            ultima_actualizacion = categoria.getUltima_actualizacion();
        }
        int numPelTot1 = 0;
        numPelTot1 = numPelTot;
        int numPelAlm1 = 0;
        numPelAlm1 = numPelAlm;

        CategoriaDTO categoriaDTO = new CategoriaDTO( id, nombre, ultima_actualizacion, numPelTot1, numPelAlm1 );

        return categoriaDTO;
    }
}

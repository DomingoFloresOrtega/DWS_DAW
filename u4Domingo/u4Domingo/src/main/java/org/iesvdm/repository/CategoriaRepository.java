package org.iesvdm.repository;

import org.iesvdm.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // con query method
    public List<Categoria> findByNombreContainingIgnoreCase(String nombre);

    public List<Categoria> findByNombreContainingIgnoreCaseOrderByNombreAsc(String nombre);

    public List<Categoria> findByNombreContainingIgnoreCaseOrderByNombreDesc(String nombre);

    // con querys
    @Query(value = "select C from Categoria C where C.nombre like %:nombre%") // agregar nativequery = true o false
    public List<Categoria> queryCategoriaContieneNombre(@Param("nombre") String nombre);

}

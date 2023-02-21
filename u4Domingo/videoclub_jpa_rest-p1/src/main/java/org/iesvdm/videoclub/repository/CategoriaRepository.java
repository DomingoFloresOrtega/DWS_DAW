package org.iesvdm.videoclub.repository;

import org.iesvdm.videoclub.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query(value = "select * from pelicula where nombre like %:buscar% order by :ordenar", nativeQuery = true)
    public List<Categoria> queryBuscarOrdenar(@Param("buscar") Optional<String> buscar, @Param("ordenar") Optional<String> ordenar);

    @Query(value = "select * from pelicula where nombre like %:buscar%", nativeQuery = true)
    public List<Categoria> queryBuscar(@Param("buscar") Optional<String> buscar);

    @Query(value = "select * from pelicula where nombre order by :ordenar", nativeQuery = true)
    public List<Categoria> queryOrdenar(@Param("ordenar") Optional<String> ordenar);

}

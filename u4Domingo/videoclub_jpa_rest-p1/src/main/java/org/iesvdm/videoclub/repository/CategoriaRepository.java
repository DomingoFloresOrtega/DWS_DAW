package org.iesvdm.videoclub.repository;

import org.iesvdm.videoclub.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query(value = "select * from categoria where nombre like %:buscar% order by nombre :ordenar", nativeQuery = true)
    public List<Categoria> queryBuscarOrdenar(@Param("buscar") Optional<String> buscar, @Param("ordenar") Optional<String> ordenar);

    @Query(value = "select * from categoria where nombre like %:buscar%", nativeQuery = true)
    public List<Categoria> queryBuscar(@Param("buscar") Optional<String> buscar);

    @Query(value = "select * from categoria order by nombre ASC", nativeQuery = true)
    public List<Categoria> queryOrdenarAsc(@Param("ordenar") Optional<String> ordenar);
    @Query(value = "select * from categoria order by nombre DESC", nativeQuery = true)
    public List<Categoria> queryOrdenarDesc(@Param("ordenar") Optional<String> ordenar);
    @Query(value = "select count(id_pelicula) as 'conteo' from categoria c left join pelicula_categoria pc on c.id_categoria = pc.id_categoria group by c.id_categoria", nativeQuery = true)
    public List<Object[]> queryCount();

}

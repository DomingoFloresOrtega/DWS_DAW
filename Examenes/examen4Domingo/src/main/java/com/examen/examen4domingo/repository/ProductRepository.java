package com.examen.examen4domingo.repository;

import com.examen.examen4domingo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from product where name like %:buscar% order by name ASC", nativeQuery = true)
    public List<Product> queryBuscarOrdenarAsc(@Param("buscar") Optional<String> buscar);

    @Query(value = "select * from product where name like %:buscar% order by name DESC", nativeQuery = true)
    public List<Product> queryBuscarOrdenarDesc(@Param("buscar") Optional<String> buscar);

    @Query(value = "select * from product where name like %:buscar%", nativeQuery = true)
    public List<Product> queryBuscar(@Param("buscar") Optional<String> buscar);

    @Query(value = "select * from product order by name ASC", nativeQuery = true)
    public List<Product> queryOrdenarAsc(@Param("ordenar") Optional<String> ordenar);

    @Query(value = "select * from product order by name DESC", nativeQuery = true)
    public List<Product> queryOrdenarDesc(@Param("ordenar") Optional<String> ordenar);
}

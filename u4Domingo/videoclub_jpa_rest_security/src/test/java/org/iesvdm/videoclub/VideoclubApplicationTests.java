package org.iesvdm.videoclub;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
class VideoclubApplicationTests {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    PeliculaRepository peliculaRepository;
    @Test
    void contextLoads() {
    }

    @Test
    public void showCategoriasWhenLoadPelicula() {

        Pelicula pelicula = this.peliculaRepository.findById(2L).get();

        Set<Categoria> categoriaSet = pelicula.getCategorias();

        System.out.println(categoriaSet);

    }

    @Autowired
    EntityManager em;

    @Test
    void testJPQL() {

        Query query1 = em.createQuery("select P from Pelicula P", Pelicula.class);
        List<Pelicula> peliculaList = query1.getResultList();
        assertThat(peliculaList).hasSize(1);

        query1 = em.createQuery("select P.idioma from Pelicula P", Idioma.class);
        List<Idioma> idiomaList = query1.getResultList();
        assertThat(idiomaList.get(0).getNombre()).isEqualTo("English");

        query1 = em.createQuery("select i from Pelicula inner join Idioma i", Idioma.class);
        idiomaList = query1.getResultList();
        assertThat(idiomaList.get(0).getNombre()).isEqualTo("English");

        query1 = em.createQuery("select P.categorias from Pelicula P", Collection.class);
        List<Collection<Categoria>> categoriasList = query1.getResultList();
        assertThat(categoriasList).hasSize(1);

        query1 = em.createQuery("select C from Pelicula P inner join P.categorias C where C.id = 1", Categoria.class);
        List<Categoria> categoriaList = query1.getResultList();
        assertThat(categoriaList.get(0).getNombre()).isEqualTo("Aventura en familia");

        query1 = em.createQuery("select distinct C from Categoria C left outer join C.peliculas P", Categoria.class);
        List<Categoria> categoria2List = query1.getResultList();
        assertThat(categoria2List).hasSize(5);

        query1 = em.createQuery("select C, P from Categoria C left outer join C.peliculas P");
        List<Object[]> multiplesEntidadesList = query1.getResultList();
        assertThat(multiplesEntidadesList).hasSize(5);

    }

    @Test
    void testPageableQueryMethod() {

        Pageable paginado = PageRequest.of(0,1
                , Sort.by("nombre").ascending());

        Page<Categoria> pageCategoria1 = this.categoriaRepository
                .findByNombreContainingIgnoreCase("", paginado );

        List<Categoria> categoriaList1 = pageCategoria1.getContent();

        categoriaList1.forEach(System.out::println);

        ///////////////////////////////////////////

        Pageable paginado2 = PageRequest.of(1,1
                , Sort.by("nombre").ascending());

        Page<Categoria> pageCategoria2 = this.categoriaRepository
                .findByNombreContainingIgnoreCase("", paginado2 );

        List<Categoria> categoriaList2 = pageCategoria2.getContent();

        categoriaList2.forEach(System.out::println);

    }

    @Test
    //Debido a un fetch lazy por tener idioma en categoria
    @Transactional
    void testPageableQueryJPQL() {

        Pageable paginado = PageRequest.of(0,1
                , Sort.by("nombre").ascending());

        Page<Categoria> pageCategoria1 = this.categoriaRepository
                .queryJPQLBuscarCategoria("", paginado );

        List<Categoria> categoriaList1 = pageCategoria1.getContent();

        categoriaList1.forEach(System.out::println);

        ///////////////////////////////////////////

        Pageable paginado2 = PageRequest.of(1,1
                , Sort.by("nombre").ascending());

        Page<Categoria> pageCategoria2 = this.categoriaRepository
                .queryJPQLBuscarCategoria("", paginado2 );

        List<Categoria> categoriaList2 = pageCategoria2.getContent();

        categoriaList2.forEach(System.out::println);

    }

    @Test
    //Debido a un fetch lazy por tener idioma en categoria
    @Transactional
    void testPageableQuerySQL() {

        Pageable paginado = PageRequest.of(0,1
                , Sort.by("nombre").ascending());

        Page<Categoria> pageCategoria1 = this.categoriaRepository
                .querySQLBuscarCategoria("", paginado );

        List<Categoria> categoriaList1 = pageCategoria1.getContent();

        categoriaList1.forEach(System.out::println);

        ///////////////////////////////////////////

        Pageable paginado2 = PageRequest.of(1,1, Sort.by("nombre").ascending());

        Page<Categoria> pageCategoria2 = this.categoriaRepository
                .querySQLBuscarCategoria("", paginado2 );

        List<Categoria> categoriaList2 = pageCategoria2.getContent();

        categoriaList2.forEach(System.out::println);

    }

    @Autowired
    CategoriaCustomRepository categoriaCustomRepository;

    @Test
    //Debido a un fetch lazy por tener idioma en categoria
    @Transactional
    void testPageableCustomRepository() {

        Pageable paginado = PageRequest.of(0,1
                , Sort.by("nombre").ascending());

        List<Categoria> categoriaList1 = this.categoriaCustomRepository
                .queryCustomCategoriaConPageable(Optional.of("")
                        , Optional.of("asc")
                        , paginado);

        categoriaList1.forEach(System.out::println);
        ///////////////////////////////////////////

        Pageable paginado2 = PageRequest.of(1,1
                , Sort.by("nombre").ascending());

        List<Categoria> categoriaList2 = this.categoriaCustomRepository
                .queryCustomCategoriaConPageable(Optional.of("")
                        , Optional.of("asc")
                        , paginado2);

        categoriaList2.forEach(System.out::println);

    }

    @Test
    void testView() {

        PeliculaView peliculaView = this.peliculaRepository.findPeliculaByIdPelicula(2);

    }


}

package org.iesvdm.u4domingo;

import jakarta.transaction.Transactional;
import org.iesvdm.domain.*;
import org.iesvdm.repository.CategoriaRepository;
import org.iesvdm.repository.PeliculaRepository;
import org.iesvdm.repository.SocioRepository;
import org.iesvdm.repository.TutorialRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Commit;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Period;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
class TutorialesApplicationTests {

	@Autowired
	TutorialRepository tutorialRepository;
	@Autowired
	SocioRepository socioRepository;
	@Autowired
	PeliculaRepository peliculaRepository;
	@Autowired
	CategoriaRepository categoriaRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testTutorialRepository() {
		// Anotacion lombok @Builder
		Tutorial tutorial1 = Tutorial.builder().title("Tutorial JPA")
				.description("Se describen los datos aquí")
				.build();

		tutorialRepository.save(tutorial1);

		List<Tutorial> tutorialList = tutorialRepository.findAll();
		tutorialList.forEach(System.out::println);
	}

	@Test
	@Order(1)
	void testSocioRepository() {

		Tarjeta tarjeta = Tarjeta.builder()
				.numero("527739412423423")
				.caducidad("04/27")
				.build();

		Socio socio = Socio.builder()
				.dni("00124123L")
				.nombre("Pedro")
				.apellidos("Picapiedra")
				.tarjeta(tarjeta)
				.build();

		tarjeta.setSocio(socio);

		socioRepository.save(socio);
		List<Socio> socioList = socioRepository.findAll();
	}

	@Transactional
	@Commit
	@Test
	void testPeliculasRepository() {

		Categoria categoria = Categoria.builder().nombre("Accion")
				.ultima_actualizacion("10/10/2020")
				.build();

		Pelicula pelicula = Pelicula.builder().titulo("Indiana Jones")
				.descripcion("Película para toda la familia de aventura")
				.anyoLanzamiento("1990")
				.idioma("Español")
				.idiomaOriginal("Inglés")
				.duracion(Duration.parse("PT1H40M"))
				.precioAlquiler(new BigDecimal("20.50"))
				.periodoAlquiler(Period.of(0,1,15))
				.clasificacion(Clasificacion.R)
				.caracteristicasEspecialesStr("Trailers,Commentaries")
				.ultimaModificacion(new Date())
				.categorias(new HashSet<>())
				.build();

		pelicula.getCategorias().add(categoria);

		peliculaRepository.save(pelicula);
	}
	@Transactional // si es LAZY
	@Commit // si se pone Transactional, es obligatorio hacer commit
	@Test
	void testCategoriasRepository() {

		Pelicula pelicula = Pelicula.builder().titulo("Indiana Jones 2")
				.descripcion("Película para toda la familia de aventura")
				.anyoLanzamiento("1993")
				.idioma("Español")
				.idiomaOriginal("Inglés")
				.duracion(Duration.parse("PT1H40M"))
				.precioAlquiler(new BigDecimal("20.50"))
				.periodoAlquiler(Period.of(0,1,15))
				.clasificacion(Clasificacion.R)
				.caracteristicasEspecialesStr("Trailers,Commentaries")
				.ultimaModificacion(new Date())
				.categorias(new HashSet<>())
				.build();

		Categoria categoria = Categoria.builder().nombre("Aventura")
				.ultima_actualizacion("10/10/2020")
				.peliculas(new HashSet<>())
				.build();

		categoria.getPeliculas().add(pelicula);

		categoriaRepository.save(categoria);
	}


	@Test
	void testTutorialWithCommentsRepository() {

		Comment comment1 = Comment.builder().content("El tutorial no está mal, pero hay cosillas que no cuenta").build();
		Comment comment2 = Comment.builder().content("Genial!").build();

		List<Comment> commentList = Arrays.asList(comment1, comment2);

//Anotacion Lombok @Builder
		Tutorial tutorial1 = Tutorial.builder().title("Tuto2 JPA")
				.description("Otro tuto sobre modelo/entidad con JPA/Hibernate")
				.build();

		Tutorial tutorialSave = tutorialRepository.save(tutorial1);
//Alternativa tutorialSave


//Alternativa tutorialFnd recargando la entidad para tener la colección Comments creada
//Tutorial tutorialFind = tutorialRepository.findById(tutorialSave.getId()).get();

//Seteamos el tutorial
		commentList.forEach( c -> c.setTutorial(tutorialSave));
//commentList.forEach( c -> c.setTutorial(tutorialFind));

		tutorialSave.setComments(commentList);
//tutorialFind.getComments().addAll(commentList);

// Segunda actualización para actualizar las FK id_tutorial de comentarios nuevos.

		tutorialRepository.save(tutorialSave);
//tutorialRepository.save(tutorialFind);

		List<Tutorial> tutorialList = tutorialRepository.findAll();
		tutorialList.forEach(System.out::println);

	}

}

package org.iesvdm.u4domingo;

import org.iesvdm.domain.Tutorial;
import org.iesvdm.repository.TutorialRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TutorialesApplicationTests {

	@Autowired
	TutorialRepository tutorialRepository;

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

}

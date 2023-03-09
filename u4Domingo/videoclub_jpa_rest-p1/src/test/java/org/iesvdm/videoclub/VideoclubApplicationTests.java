package org.iesvdm.videoclub;

import jakarta.transaction.Transactional;
import org.iesvdm.videoclub.domain.Categoria;
import org.iesvdm.videoclub.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VideoclubApplicationTests {

    @Autowired
    private CategoriaRepository cr;
    @Test
    @Transactional
    void contextLoads() {
        System.out.println();
    }

}

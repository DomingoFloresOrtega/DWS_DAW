package org.iesvdm.videoclub.repository;


import org.iesvdm.videoclub.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByEmail(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
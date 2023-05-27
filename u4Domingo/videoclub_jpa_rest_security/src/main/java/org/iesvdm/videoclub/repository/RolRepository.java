package org.iesvdm.videoclub.repository;


import org.iesvdm.videoclub.domain.ERol;
import org.iesvdm.videoclub.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRol(ERol rol);
}
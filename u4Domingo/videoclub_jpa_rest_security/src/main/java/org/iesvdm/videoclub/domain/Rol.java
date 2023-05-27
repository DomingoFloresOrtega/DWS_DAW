package org.iesvdm.videoclub.domain;


import jakarta.persistence.*;


@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERol rol;

    public Rol() {

    }

    public Rol(ERol rol) {
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERol getRol() {
        return rol;
    }

    public void setRol(ERol rol) {
        this.rol = rol;
    }
}
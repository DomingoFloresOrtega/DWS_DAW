package org.iesvdm.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
        name = "socios",
        schema = "bbdd_tutoriales",
        indexes = {@Index(name = "name_index", columnList = "nombre", unique = true)}
)
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private int id;

    @Column(name = "dni_socio")
    private String dni;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
    private Tarjeta tarjeta;
}

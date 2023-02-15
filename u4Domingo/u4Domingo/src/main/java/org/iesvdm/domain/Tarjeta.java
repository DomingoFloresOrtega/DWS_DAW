package org.iesvdm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
        name = "tarjetas")
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private int id;

    @Column(name = "numero", length = 16)
    private String numero;

    @Column(name = "caducidad", nullable = false, length = 5)
    private String caducidad;

    @OneToOne
    @JoinColumn(name = "id_tarjeta", foreignKey = @ForeignKey(name = "FK_DNI_TARJETA"))
    @MapsId
    @JsonIgnore
    @ToString.Exclude
    private Socio socio;
}

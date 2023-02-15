package org.iesvdm.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Period;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pelicula;

    private String titulo;

    @Lob
    private String descripcion;

    @Column(name = "anyo_lanzamiento", length = 4, columnDefinition = "YEAR")
    private String anyoLanzamiento;

    private String idioma;

    @Column( length = 50)
    private String idiomaOriginal;

    private Period periodoAlquiler;

    @Column(precision = 4, scale = 2)
    private BigDecimal precioAlquiler;
    private Duration duracion;

    @Column(precision = 5, scale = 2)
    private BigDecimal costeReemplazo;

    private Clasificacion clasificacion;

    @ManyToMany(cascade = "")
    @JoinTable(
            name = "pelicula_categoria",
            joinColumns = @JoinColumn(name = "id_pelicula", referencedColumnName = "id_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria"))
    Set<Categoria> categorias = new HashSet<>();

    @Column(columnDefinition = "set('Trailers','Commentaries','Deleted Scenes','Behind the Scenes')")
    private String caracteristicasEspecialesStr;

    private Date ultimaModificacion;

    public Set<String> getCaracteristicasEspeciales() {
        if(caracteristicasEspecialesStr == null) {
            return Collections.emptySet();
        } else {
            return Collections.unmodifiableSet(
                    new HashSet<String>(Arrays.asList(caracteristicasEspecialesStr.split(",")))
            );
        }
    }

    public void setCaracteristicasEspeciales(Set<String> caracteristicasEspeciales) {
        if(caracteristicasEspeciales == null)
            caracteristicasEspecialesStr = null;
        else
            caracteristicasEspecialesStr = String.join(",", caracteristicasEspeciales);
    }
}

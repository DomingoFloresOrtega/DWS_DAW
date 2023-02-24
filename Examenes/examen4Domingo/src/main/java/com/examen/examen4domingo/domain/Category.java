package com.examen.examen4domingo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 120)
    private String name;

    @Column(name = "descrip", length = 120)
    private String descrip;
}
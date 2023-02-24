package com.examen.examen4domingo.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "name", length = 120)
    private String name;

    @Column(name = "descrip", length = 255)
    private String descrip;

    @Column(name = "image_url", length = 120)
    private String image_url;

    @Column(name = "sku", length = 120)
    private String sku;

    @Column(name = "price", length = 10)
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = false)
    private Category category_id;

}

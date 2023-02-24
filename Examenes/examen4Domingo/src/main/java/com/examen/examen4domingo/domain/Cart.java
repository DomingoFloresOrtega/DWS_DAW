package com.examen.examen4domingo.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="cart_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_CART"))
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "created_date")
    @JsonFormat(pattern = "yyyy-MM-dd",  shape = JsonFormat.Shape.STRING)
    private Date created_date;

    @Column(name = "modified_date")
    @JsonFormat(pattern = "yyyy-MM-dd",  shape = JsonFormat.Shape.STRING)
    private Date modified_date;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}

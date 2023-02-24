package com.examen.examen4domingo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long id;

    @Column(name = "email", length = 120)
    private String email;

    @Column(name = "username", length = 120)
    private String username;

    @Column(name = "password", length = 120)
    private String password;

    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy-mm-dd",  shape = JsonFormat.Shape.STRING)
    private Date birthdate;
}

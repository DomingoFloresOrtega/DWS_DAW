package org.iesvdm.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
        name = "tutorials",
        schema = "bbdd_tutoriales",
        indexes = {@Index(name = "title_index", columnList = "title", unique = true)}
)
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tutorial")
    private long id;

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

    private Date publicationDate;

    @OneToMany(mappedBy = "tutorial", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Comment> comments;
}

package com.erosproject.database.category.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String name;

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String description;

    private Boolean is_active;

    @CreationTimestamp
    private LocalDate created_at;

    @CreationTimestamp
    private LocalDate updated_at;

    @PrePersist
    public void prePersist() {
        setCreated_at(LocalDate.now());
    }

}

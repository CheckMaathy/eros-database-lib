package com.erosproject.database.product.model;

import com.erosproject.database.category.model.Category;
import com.erosproject.database.enums.SizeEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String name;

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String description;

    @OneToOne
    private Category category;

    @Enumerated(EnumType.STRING)
    private SizeEnum size;

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private BigDecimal value;

    @Column(nullable = false)
    private Boolean is_active;

    @CreationTimestamp
    private LocalDate created_at;

    @CreationTimestamp
    private LocalDate updated_at;
//
//    @PrePersist
//    public void prePersist() {
//        setCreated_at(LocalDate.now());
//        setUpdated_at(LocalDate.now());
//    }

}

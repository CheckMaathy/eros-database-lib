package com.erosproject.database.user.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.nickname.obrigatorio}")
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 11, unique = true)
    @NotNull
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(nullable = false)
    private Boolean is_admin;

    @Column(nullable = false)
    private String passcode;

    @CreationTimestamp
    private LocalDate created_at;

    @CreationTimestamp
    private LocalDate updated_at;

//    @PrePersist
//    public void prePersist() {
//        setCreated_at(LocalDate.now());
//    }
}

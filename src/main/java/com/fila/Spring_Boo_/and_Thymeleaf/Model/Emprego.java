package com.fila.Spring_Boo_.and_Thymeleaf.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter


@Entity
public class Emprego {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 4)
    private String titulo;

    @NotNull
    @Size(min = 4)
    private String empresa;

    @NotNull
    @Size(min = 10)
    private String descricao;
}

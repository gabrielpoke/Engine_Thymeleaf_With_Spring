package com.fila.Spring_Boo_.and_Thymeleaf.Model;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter


@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Collection<Usuarios> usuarios;

    public Role(){

    }

    public Role(String role) {
        this.role = role;
    }
}

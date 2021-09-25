package com.fila.Spring_Boo_.and_Thymeleaf.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.*;
import java.util.Collection;


@Getter
@Setter

@Entity
@Table(name = "user")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String senha;

    @Column(name = "user_nome")
    private String nome;

    @Column(name = "user_sobrenome")
    private String sobrenome;

    @Column(name = "user_status")
    private Boolean status;

    @Column(name = "user_username")
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public Usuarios(){}

    public Usuarios(String email, String senha, String nome, String sobrenome, Boolean status, String username) {

        this.email = email;

        this.senha = senha;

        this.nome = nome;

        this.sobrenome = sobrenome;

        this.status = status;

        this.username = username;
    }


    public void setSenha(String senha) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        this.senha = passwordEncoder.encode(senha);

    }
}

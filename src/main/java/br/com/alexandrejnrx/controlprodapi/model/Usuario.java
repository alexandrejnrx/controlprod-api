package br.com.alexandrejnrx.controlprodapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(name = "nome_usuario", nullable = false, length = 20, unique = true)
    private String nomeUsuario;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 255)
    private String senha;

}

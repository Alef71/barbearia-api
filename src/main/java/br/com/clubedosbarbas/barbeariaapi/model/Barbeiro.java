package br.com.clubedosbarbas.barbeariaapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Barbeiro")
@Table(name = "barbeiro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String senha;

    @Column(name = "foto_url")
    private String fotoUrl;

    @Column(length = 20)
    private String celular;

    @Column(length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String tipo;
}
package com.example.demo.entities;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;


@Entity
@Getter @Setter
public class Processos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataCadastro;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, unique = true)
    private String nomePaciente;

    @Column(nullable = false, unique = true)
    private String cpfPaciente;

    @Column(nullable = false, unique = true)
    private String susPaciente;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false, unique = true)
    private String cepPaciente;

    @Column(nullable = false, unique = true)
    private String enderecoPaciente;

    @OneToMany
    @JoinColumn(name = "idProcessos")
    private List<Armazenamento> armazenamentos;

    @OneToMany
    @JoinColumn(name = "idProcessos")
    private List<Entrega> entregas;

    @ElementCollection
    @CollectionTable(name = "processo_insumos", joinColumns = @JoinColumn(name = "idProcessos"))
    @Column(name = "idInsumos")
    private List<Long> insumosIds;

    @Column(nullable = false)
    private int quantidadeInsumos;
}

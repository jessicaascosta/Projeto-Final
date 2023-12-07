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
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@NamedQuery(name = "Insumos.getProcessosPorUsuario", query = "SELECT t FROM Processos t WHERE t.usuario.id=:idUsuario")

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
    @JoinColumn(name = "usuario_id", nullable = false)
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
    @JoinColumn(name = "processo_id")
    private List<Armazenamento> armazenamentos;

    @OneToMany
    @JoinColumn(name = "processo_id")
    private List<Entrega> entregas;

    @ElementCollection
    @CollectionTable(name = "processo_insumos", joinColumns = @JoinColumn(name = "processo_id"))
    @Column(name = "insumo_id")
    private List<Long> insumosIds;

    @Column(nullable = false)
    private int quantidadeInsumos;
}

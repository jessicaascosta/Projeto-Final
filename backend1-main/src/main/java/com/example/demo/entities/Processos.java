package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
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
    private Integer id;


    @Column(nullable = false)
    private LocalDate dataCadastro;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String nomePaciente;

    @Column(nullable = false)
    private String cpfPaciente;

    @Column(nullable = false)
    private String susPaciente;


    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String cepPaciente;

    @Column(nullable = false)
    private String enderecoPaciente;

    @ManyToMany
    @JoinTable(
        name = "processo_insumos",
        joinColumns = @JoinColumn(name = "processo_id"),
        inverseJoinColumns = @JoinColumn(name = "insumo_id")
    )
    private List<Insumos> insumos;

    @Column(nullable = false)
    private int quantidadeInsumos;
}

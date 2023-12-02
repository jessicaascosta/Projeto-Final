package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Processos;

public interface ProcessosRepository extends JpaRepository<Processos, Integer>{
    List<Processos> getProcessosPorUsuario(Integer idUsuario);
}

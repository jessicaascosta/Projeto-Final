package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Armazenamento;

@Repository
public interface ArmazenamentoRepository extends JpaRepository<Armazenamento, Integer>{
    
}
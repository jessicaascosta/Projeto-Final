package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Processos;

public interface ProcessosRepository extends JpaRepository<Processos, Integer>{
    
}

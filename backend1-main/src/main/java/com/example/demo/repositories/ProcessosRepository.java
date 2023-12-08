package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Processos;

@Repository
public interface ProcessosRepository extends JpaRepository<Processos, Long>{
    
}

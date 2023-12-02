package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Insumos;

public interface InsumosRepository extends JpaRepository<Insumos, Integer>{
    
}

package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{
    
}


package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
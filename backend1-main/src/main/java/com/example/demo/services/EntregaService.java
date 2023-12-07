package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Entrega;
import com.example.demo.repositories.EntregaRepository;

public class EntregaService {
    @Autowired
    private EntregaRepository entregaRepository;

    public Entrega getEntrega(Integer idEntrega) {
        Optional<Entrega> entrega = entregaRepository.findById(idEntrega);
        return entrega.get();
    }

    public Entrega salvar(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    public Entrega atualizar(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    public void remover(Integer idEntrega) {
        entregaRepository.deleteById(idEntrega);
    }
}

package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Entrega;
import com.example.demo.repositories.EntregaRepository;

@Service
public class EntregaService {
    @Autowired
    private EntregaRepository entregaRepository;

    public Entrega getEntrega(Long idEntrega) {
        Optional<Entrega> entrega = entregaRepository.findById(idEntrega);
        return entrega.get();
    }

    public Entrega salvar(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    public Entrega atualizar(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    public void remover(Long idEntrega) {
        entregaRepository.deleteById(idEntrega);
    }
}

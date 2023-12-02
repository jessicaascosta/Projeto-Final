package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Armazenamento;
import com.example.demo.repositories.ArmazenamentoRepository;

public class ArmazenamentoService {
    @Autowired
    private ArmazenamentoRepository armazenamentoRepository;

    public Armazenamento getEstoque(Integer idArmazenamento) {
        Optional<Armazenamento> armazenamento = armazenamentoRepository.findById(idArmazenamento);
        return armazenamento.get();
    }

    public Armazenamento salvar(Armazenamento armazenamento) {
        return armazenamentoRepository.save(armazenamento);
    }

    public Armazenamento atualizar(Armazenamento armazenamento) {
        return armazenamentoRepository.save(armazenamento);
    }

    public void remover(Integer idArmazenamento) {
        armazenamentoRepository.deleteById(idArmazenamento);
    }
}

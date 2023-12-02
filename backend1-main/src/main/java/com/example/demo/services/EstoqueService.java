package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Estoque;
import com.example.demo.repositories.EstoqueRepository;

@Service
public class EstoqueService {
    
    @Autowired
    private EstoqueRepository estoqueRepository;

    public Estoque getEstoque(Integer idEstoque) {
        Optional<Estoque> estoque = estoqueRepository.findById(idEstoque);
        return estoque.get();
    }

    public Estoque salvar(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public Estoque atualizar(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public void remover(Integer idEstoque) {
        estoqueRepository.deleteById(idEstoque);
    }

}
package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Insumos;
import com.example.demo.repositories.InsumosRepository;

@Service
public class InsumosService {
    
    @Autowired
    private InsumosRepository insumosRepository;

    public Insumos getInsumos(Integer idInsumos) {
        Optional<Insumos> insumos = insumosRepository.findById(idInsumos);
        return insumos.get();
    }

    public Insumos salvar(Insumos insumos) {
        return insumosRepository.save(insumos);
    }

    public Insumos atualizar(Insumos insumos) {
        return insumosRepository.save(insumos);
    }

    public void remover(Integer idInsumos) {
        insumosRepository.deleteById(idInsumos);
    }


}

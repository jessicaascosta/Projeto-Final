package com.example.demo.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Processos;
import com.example.demo.repositories.ProcessosRepository;

@Service
public class ProcessosService {
    
    @Autowired
    private ProcessosRepository processosRepository;

    public Processos getProcessos(Long idProcessos) {
        Optional<Processos> processos = processosRepository.findById(idProcessos);
        return processos.get();
    }
    
    public Processos salvar(Processos processos) {
        return processosRepository.save(processos);
    }

    public Processos atualizar(Processos processos) {
        return processosRepository.save(processos);
    }

    public void remover(Long idProcessos) {
        processosRepository.deleteById(idProcessos);
    }

}

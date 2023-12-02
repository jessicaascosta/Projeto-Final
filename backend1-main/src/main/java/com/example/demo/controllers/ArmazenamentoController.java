package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Armazenamento;
import com.example.demo.services.ArmazenamentoService;

public class ArmazenamentoController {
    @Autowired
    ArmazenamentoService armazenamentoService;
    
    @GetMapping("/{idArmazenamento}")
    @Secured(value = { "ROLE_ADMIN", "ROLE_ASSISTENTE", "ROLE_FARMACO" })
    public Armazenamento getArmazenamento(@PathVariable Integer idArmazenamento) {
        Armazenamento armazenamento = armazenamentoService.getEstoque(idArmazenamento);
        return armazenamento;
    }

    @PostMapping
    @Secured(value = { "ROLE_FARMACO" })
    public void cadastrarArmazenamento(@RequestBody Armazenamento armazenamento) {
        armazenamentoService.salvar(armazenamento);
    }

    @PutMapping
    @Secured(value = { "ROLE_FARMACO" })
    public void atualizarArmazenamento(@RequestBody Armazenamento armazenamento) {
        armazenamentoService.atualizar(armazenamento);
    }

    @DeleteMapping("/{idEstoque}")
    @Secured(value = { "ROLE_FARMACO" })
    public void removerArmazenamento(@PathVariable Integer idArmazenamento) {
        armazenamentoService.remover(idArmazenamento);
    }
}

package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Entrega;
import com.example.demo.services.EntregaService;

public class EntregaController {
    @Autowired
    EntregaService entregaService;
    
    @GetMapping("/{idEntrega}")
    @Secured(value = { "ROLE_ADMIN", "ROLE_ASSISTENTE", "ROLE_FARMACO" })
    public Entrega getEntrega(@PathVariable Integer idEntrega) {
        Entrega entrega = entregaService.getEntrega(idEntrega);
        return entrega;
    }

    @PostMapping
    @Secured(value = { "ROLE_FARMACO" })
    public void cadastrarEntrega(@RequestBody Entrega entrega) {
        entregaService.salvar(entrega);
    }

    @PutMapping
    @Secured(value = { "ROLE_FARMACO" })
    public void atualizarEntrega(@RequestBody Entrega entrega) {
        entregaService.atualizar(entrega);
    }

    @DeleteMapping("/{idEntrega}")
    @Secured(value = { "ROLE_FARMACO" })
    public void removerEntrega(@PathVariable Integer idEntrega) {
        entregaService.remover(idEntrega);
    }
}

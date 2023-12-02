package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Insumos;
import com.example.demo.services.InsumosService;

@RestController
@RequestMapping("/insumos")
public class InsumosController {

    @Autowired
    InsumosService insumosService;
    
    @GetMapping("/{idInsumos}")
    @Secured(value = { "ROLE_ADMIN", "ROLE_ASSISTENTE", "ROLE_FARMACO" })
    public Insumos getInsumos(@PathVariable Integer idInsumos) {
        Insumos insumos = insumosService.getInsumos(idInsumos);
        return insumos;
    }

    @PostMapping
    @Secured(value = { "ROLE_FARMACO" })
    public void cadastrarInsumos(@RequestBody Insumos insumos) {
        insumosService.salvar(insumos);
    }

    @PutMapping
    @Secured(value = { "ROLE_FARMACO" })
    public void atualizarInsumos(@RequestBody Insumos insumos) {
        insumosService.atualizar(insumos);
    }

    @DeleteMapping("/{idInsumos}")
    @Secured(value = { "ROLE_FARMACO" })
    public void removerInsumos(@PathVariable Integer idInsumos) {
        insumosService.remover(idInsumos);
    }
}

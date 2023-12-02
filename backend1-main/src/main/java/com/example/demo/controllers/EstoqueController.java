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

import com.example.demo.entities.Estoque;
import com.example.demo.services.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    EstoqueService estoqueService;
    
    @GetMapping("/{idEstoque}")
    @Secured(value = { "ROLE_ADMIN", "ROLE_ASSISTENTE", "ROLE_FARMACO" })
    public Estoque getEstoque(@PathVariable Integer idEstoque) {
        Estoque estoque = estoqueService.getEstoque(idEstoque);
        return estoque;
    }

    @PostMapping
    @Secured(value = { "ROLE_FARMACO" })
    public void cadastrarEstoque(@RequestBody Estoque estoque) {
        estoqueService.salvar(estoque);
    }

    @PutMapping
    @Secured(value = { "ROLE_FARMACO" })
    public void atualizarEstoque(@RequestBody Estoque estoque) {
        estoqueService.atualizar(estoque);
    }

    @DeleteMapping("/{idEstoque}")
    @Secured(value = { "ROLE_FARMACO" })
    public void removerEstoque(@PathVariable Integer idEstoque) {
        estoqueService.remover(idEstoque);
    }
}

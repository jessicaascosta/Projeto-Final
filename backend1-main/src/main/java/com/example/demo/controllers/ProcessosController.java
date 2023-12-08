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

import com.example.demo.entities.Processos;
import com.example.demo.services.ProcessosService;

@RestController
@RequestMapping("/processos")
public class ProcessosController {

    @Autowired
    ProcessosService processosService;
    
    @GetMapping("/{idProcessos}")
    @Secured(value = { "ROLE_ADMIN", "ROLE_ASSISTENTE", "ROLE_FARMACO" })
    public Processos getProcessos(@PathVariable Integer idProcessos) {
        Processos processos = processosService.getProcessos(idProcessos);
        return processos;
    }

    @PostMapping
    @Secured(value = { "ROLE_ASSISTENTE" })
    public void cadastrarProcessos(@RequestBody Processos processos) {
        processosService.salvar(processos);
    }

    @PutMapping
    @Secured(value = { "ROLE_ASSISTENTE" })
    public void atualizarProcessos(@RequestBody Processos processos) {
        processosService.atualizar(processos);
    }

    @DeleteMapping("/{idProcessos}")
    @Secured(value = { "ROLE_ASSISTENTE" })
    public void removerProcessos(@PathVariable Integer idProcessos) {
        processosService.remover(idProcessos);
    }


}

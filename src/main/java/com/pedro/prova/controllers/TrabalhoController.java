package com.pedro.prova.controllers;

import com.pedro.prova.DTOs.TrabalhoDTO;
import com.pedro.prova.services.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @PostMapping("/criar-trabalho")
    public ResponseEntity<?> criarTrabalho(@RequestBody TrabalhoDTO dto) {
        return trabalhoService.criarTrabalho(dto);
    }

    @GetMapping("/listar-trabalhos")
    public ResponseEntity<List<TrabalhoDTO>> listarTodos() {
        return trabalhoService.listarTodos();
    }

    @GetMapping("/trabalho/{id}")
    public ResponseEntity<TrabalhoDTO> buscarPorId(@PathVariable Long id) {
        return trabalhoService.buscarPorId(id);
    }

    @DeleteMapping("/trabalho/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return trabalhoService.deletar(id);
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<TrabalhoDTO>> listarPorPessoa(@PathVariable Long pessoaId) {
        return trabalhoService.listarPorPessoa(pessoaId);
    }
}
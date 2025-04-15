package com.pedro.prova.controllers;


import com.pedro.prova.entities.Pessoa;
import com.pedro.prova.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    //create
    @PostMapping("/criar-pessoa")
    public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.createPessoa(pessoa);
    }


    //get all
    @GetMapping("/listar-pessoas")
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }


    //get pessoa by id
    @GetMapping("/pessoa/{id}")
    public ResponseEntity<Optional<Pessoa>> getPessoaById(@PathVariable Long id) {
        return pessoaService.getPessoaById(id);
    }


    //delete pessoa by id
    @DeleteMapping("/pessoa/{id}")
    public ResponseEntity<?> deletePessoaById(@PathVariable Long id) {
        return pessoaService.deletePessoaById(id);
    }



    //update pessoa by id
    @PutMapping("update-pessoa/{id}")
    public ResponseEntity<Pessoa> updatePessoa(@RequestBody Pessoa pessoa, @PathVariable Long id) {
        return pessoaService.updatePessoaById(pessoa, id);
    }


}

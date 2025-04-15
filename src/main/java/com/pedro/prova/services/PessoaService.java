package com.pedro.prova.services;

import com.pedro.prova.entities.Pessoa;
import com.pedro.prova.repositories.PessoaRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepoitory pessoaRepoitory;


    //create
    public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa) {
        Pessoa newPessoa = pessoaRepoitory.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPessoa);
    }


    //get all
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        List<Pessoa> allPessoas = pessoaRepoitory.findAll();
        return ResponseEntity.ok(allPessoas);
    }


    //get by id
    public ResponseEntity<Optional<Pessoa>> getPessoaById(@PathVariable Long id) {
        Optional<Pessoa> getPessoaById = pessoaRepoitory.findById(id);
        return ResponseEntity.ok(getPessoaById);
    }


    //delete
    public ResponseEntity<?> deletePessoaById(@PathVariable Long id) {
        pessoaRepoitory.deleteById(id);
        return ResponseEntity.ok("Pessoa deletada com sucesso!");
    }


    //update
    public ResponseEntity<Pessoa> updatePessoaById(@RequestBody Pessoa updatePessoa, @PathVariable Long id) {
        return pessoaRepoitory.findById(id).map(pessoa -> {
            pessoa.setNome(updatePessoa.getNome());
            pessoa.setCpf(updatePessoa.getCpf());

            Pessoa updatedPessoa = pessoaRepoitory.save(pessoa);
            return ResponseEntity.ok(updatedPessoa);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }


}

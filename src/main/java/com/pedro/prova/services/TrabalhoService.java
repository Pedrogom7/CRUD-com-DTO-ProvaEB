package com.pedro.prova.services;

import com.pedro.prova.DTOs.TrabalhoDTO;
import com.pedro.prova.entities.Pessoa;
import com.pedro.prova.entities.Trabalho;
import com.pedro.prova.repositories.PessoaRepoitory;
import com.pedro.prova.repositories.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    @Autowired
    private PessoaRepoitory pessoaRepository;

    public ResponseEntity<?> criarTrabalho(TrabalhoDTO dto) {
        Optional<Pessoa> pessoaOpt = pessoaRepository.findById(dto.getPessoaId());

        if (pessoaOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Pessoa não encontrada");
        }

        Trabalho trabalho = new Trabalho();
        trabalho.setDescricao(dto.getDescricao());
        trabalho.setPessoa(pessoaOpt.get());

        trabalhoRepository.save(trabalho);
        return ResponseEntity.ok("Trabalho criado com sucesso");
    }

    public ResponseEntity<List<TrabalhoDTO>> listarTodos() {
        List<TrabalhoDTO> lista = trabalhoRepository.findAll()
                .stream()
                .map(TrabalhoDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    public ResponseEntity<TrabalhoDTO> buscarPorId(Long id) {
        Optional<Trabalho> trabalhoOpt = trabalhoRepository.findById(id);
        return trabalhoOpt
                .map(trabalho -> ResponseEntity.ok(new TrabalhoDTO(trabalho)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> deletar(Long id) {
        if (!trabalhoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        trabalhoRepository.deleteById(id);
        return ResponseEntity.ok("Trabalho deletado com sucesso");
    }

    public ResponseEntity<List<TrabalhoDTO>> listarPorPessoa(Long pessoaId) {
        List<TrabalhoDTO> lista = trabalhoRepository.findByPessoaId(pessoaId)
                .stream()
                .map(TrabalhoDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }
}
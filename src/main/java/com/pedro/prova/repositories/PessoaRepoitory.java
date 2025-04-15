package com.pedro.prova.repositories;

import com.pedro.prova.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepoitory extends JpaRepository<Pessoa, Long> {
}

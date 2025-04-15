package com.pedro.prova.DTOs;
import com.pedro.prova.entities.Trabalho;
import jakarta.persistence.*;

public class TrabalhoDTO {

    private Long id;
    private String descricao;
    private Long pessoaId;

    public TrabalhoDTO() {
    }

    public TrabalhoDTO(Long id, String descricao, Long pessoaId) {
        this.id = id;
        this.descricao = descricao;
        this.pessoaId = pessoaId;
    }

    public TrabalhoDTO(Trabalho trabalho) {
        this.id = trabalho.getId();
        this.descricao = trabalho.getDescricao();
        this.pessoaId = trabalho.getPessoa() != null ? trabalho.getPessoa().getId() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }
}
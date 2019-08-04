package com.fsantos.jurisoft.model.processo.questionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Questionario {

    @Id @GeneratedValue
    private UUID id;

    private String nome;
    private String descricao;

   @OneToMany(mappedBy = "questionario")
    private Set<Pergunta> perguntas = new HashSet<>();
}

package com.fsantos.jurisoft.model.processo.questionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Pergunta {

    @Id @GeneratedValue
    private UUID id;
    private String nome;

    @OneToMany(mappedBy = "pergunta")
    private Set<Alternativa> alternativas = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "questionario_id")
    private Questionario questionario;
}

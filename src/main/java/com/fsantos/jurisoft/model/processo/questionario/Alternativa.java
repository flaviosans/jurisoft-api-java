package com.fsantos.jurisoft.model.processo.questionario;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Alternativa {

    @Id @GeneratedValue
    private UUID id;
    private String nome;
    private int ordem;

    @ManyToOne
    @JoinColumn(name = "pergunta_id", nullable = false)
    private Pergunta pergunta;

    @OneToMany(mappedBy = "alternativa")
    private Set<Detalhe> detalhe = new HashSet<>();
}

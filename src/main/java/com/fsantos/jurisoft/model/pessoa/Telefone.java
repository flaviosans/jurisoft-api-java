package com.fsantos.jurisoft.model.pessoa;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Telefone {

    @Id @GeneratedValue
    private UUID id;
    private String descricao;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}

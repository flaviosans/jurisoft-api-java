package com.fsantos.jurisoft.model.Pessoa;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Email {

    @Id @GeneratedValue
    private UUID id;
    private String descricao;
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

}

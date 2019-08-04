package com.fsantos.jurisoft.model.pessoa.endereco;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Estado {

    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String sigla;

}

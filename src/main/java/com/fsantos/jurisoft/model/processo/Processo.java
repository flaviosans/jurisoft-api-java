package com.fsantos.jurisoft.model.processo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Processo {

    @Id @GeneratedValue
    private UUID id;
    private String nome;
    private String descricao;


}

package com.fsantos.jurisoft.model.pessoa.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Cidade {

    @Id @GeneratedValue
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

//    @OneToMany(mappedBy = "cidade")
//    private Set<Endereco> enderecos = new HashSet<>();
}

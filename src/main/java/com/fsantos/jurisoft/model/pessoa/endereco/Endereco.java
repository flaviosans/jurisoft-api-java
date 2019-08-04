package com.fsantos.jurisoft.model.pessoa.endereco;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsantos.jurisoft.model.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Endereco implements Serializable {

    public static final Long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String descricao;
    @NotNull
    private String logradouro;
    private String complemento;
    private String bairro;

//    @ManyToOne
//    @JoinColumn(name = "cidade_id", nullable = false)
//    private Cidade cidade;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pessoa_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private Pessoa pessoa;
}


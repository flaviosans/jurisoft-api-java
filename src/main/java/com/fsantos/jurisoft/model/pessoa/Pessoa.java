package com.fsantos.jurisoft.model.pessoa;

import com.fsantos.jurisoft.enumerable.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Pessoa {

    @Id @GeneratedValue
    private UUID id;

    @NotNull
    private String nome;
    @Column(length = 11)
    private String cpf;
    private String rg;
    private String carteiraDeTrabalho;
    private String pis;
    private String profissao;
    private LocalDate dataDeNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

/*    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Endereco> enderecos = new HashSet<>();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Telefone> telefones = new HashSet<>();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Email> emails = new HashSet<>();*/
}

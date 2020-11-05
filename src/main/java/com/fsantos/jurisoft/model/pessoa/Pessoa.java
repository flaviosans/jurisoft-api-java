package com.fsantos.jurisoft.model.pessoa;

import com.fsantos.jurisoft.enumerable.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Where(clause = "deleted = false")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private boolean deleted;

    @Enumerated(EnumType.STRING)
    private Genero genero;

/*
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Endereco> enderecos = new HashSet<>();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Telefone> telefones = new HashSet<>();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Email> emails = new HashSet<>();*/
}

package com.fsantos.jurisoft.repository.pessoa;

import com.fsantos.jurisoft.model.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID>{

}

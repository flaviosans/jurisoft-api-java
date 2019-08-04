package com.fsantos.jurisoft.repository.pessoa.endereco;

import com.fsantos.jurisoft.model.pessoa.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
    Set<Endereco> findByPessoaId(UUID pessoaId);
}

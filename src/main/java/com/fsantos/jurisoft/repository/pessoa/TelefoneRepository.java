package com.fsantos.jurisoft.repository.pessoa;

import com.fsantos.jurisoft.model.pessoa.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface TelefoneRepository extends JpaRepository<Telefone, UUID> {
    Set<Telefone> findByPessoaId(UUID pessoaId);
}

package com.fsantos.jurisoft.repository.pessoa;

import com.fsantos.jurisoft.model.pessoa.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
    Set<Email> findByPessoaId(UUID pessoaId);
}

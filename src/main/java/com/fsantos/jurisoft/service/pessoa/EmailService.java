package com.fsantos.jurisoft.service.pessoa;

import com.fsantos.jurisoft.exception.ResourceNotFoundException;
import com.fsantos.jurisoft.model.pessoa.Email;
import com.fsantos.jurisoft.model.pessoa.Pessoa;
import com.fsantos.jurisoft.repository.pessoa.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class EmailService {
    @Autowired
    private EmailRepository _emailRepository;
    @Autowired
    private PessoaService _pessoaService;

    public Email save(UUID pessoaId, Email email) throws ResourceNotFoundException {
        Pessoa pessoa = _pessoaService.get(pessoaId);
        email.setPessoa(pessoa);
        return this._emailRepository.save(email);
    }

    public Set<Email> get(UUID pessoaId) throws ResourceNotFoundException{
        Pessoa pessoa = _pessoaService.get(pessoaId);
        return _emailRepository.findByPessoaId(pessoa.getId());
    }

    public Email get(UUID pessoaId, UUID emailId) throws ResourceNotFoundException{
        Optional<Email> optionalEmail = _emailRepository.findById(emailId);
        if (!optionalEmail.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return optionalEmail.get();
    }

    public Email update(UUID pessoaId, UUID emailId, Email email) throws ResourceNotFoundException{
        Email e = get(pessoaId, emailId);
        e.setDescricao(email.getDescricao());
        e.setEndereco(email.getEndereco());
        return _emailRepository.save(e);
    }

    public void delete(UUID pessoaId, UUID enderecoId) throws ResourceNotFoundException{
        Email e = get(pessoaId, enderecoId);
        _emailRepository.delete(e);
    }
}

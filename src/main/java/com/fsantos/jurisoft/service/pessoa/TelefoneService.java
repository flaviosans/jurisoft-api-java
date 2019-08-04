package com.fsantos.jurisoft.service.pessoa;

import com.fsantos.jurisoft.exception.ResourceNotFoundException;
import com.fsantos.jurisoft.model.pessoa.Pessoa;
import com.fsantos.jurisoft.model.pessoa.Telefone;
import com.fsantos.jurisoft.repository.pessoa.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class TelefoneService {
    @Autowired
    private TelefoneRepository _TelefoneRepository;

    @Autowired
    private PessoaService _PessoaService;

    public Telefone save(UUID pessoaId, Telefone telefone) throws ResourceNotFoundException{
        Pessoa pessoa = _PessoaService.get(pessoaId);
        telefone.setPessoa(pessoa);
        return this._TelefoneRepository.save(telefone);
    }

    public Set<Telefone> get(UUID pessoaId) throws ResourceNotFoundException{
        Pessoa pessoa = _PessoaService.get(pessoaId);
        return _TelefoneRepository.findByPessoaId(pessoa.getId());
    }

    public Telefone get(UUID pessoaId, UUID telefoneId) throws ResourceNotFoundException{
        Optional<Telefone> optionalTelefone = _TelefoneRepository.findById(telefoneId);
        if (!optionalTelefone.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return optionalTelefone.get();
    }

    public Telefone update(UUID pessoaId, UUID telefoneId, Telefone telefone) throws ResourceNotFoundException{
        Telefone t = get(pessoaId, telefoneId);
        t.setDescricao(telefone.getDescricao());
        t.setNumero(telefone.getNumero());
        return _TelefoneRepository.save(t);
    }

    public void delete(UUID pessoaId, UUID telefoneId) throws ResourceNotFoundException {
        Telefone t = get(pessoaId, telefoneId);
        _TelefoneRepository.delete(t);
    }
}

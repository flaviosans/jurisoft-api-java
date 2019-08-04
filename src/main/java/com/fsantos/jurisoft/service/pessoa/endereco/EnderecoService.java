package com.fsantos.jurisoft.service.pessoa.endereco;

import com.fsantos.jurisoft.exception.ResourceNotFoundException;
import com.fsantos.jurisoft.model.pessoa.Pessoa;
import com.fsantos.jurisoft.model.pessoa.endereco.Endereco;
import com.fsantos.jurisoft.repository.pessoa.endereco.EnderecoRepository;
import com.fsantos.jurisoft.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository _enderecoRepository;

    @Autowired
    private PessoaService _pessoaService;

    public Endereco save(UUID pessoaId, Endereco endereco) throws ResourceNotFoundException {
        Pessoa pessoa = _pessoaService.get(pessoaId);
        endereco.setPessoa(pessoa);
        return this._enderecoRepository.save(endereco);
    }

    public Set<Endereco> get(UUID pessoaId) throws ResourceNotFoundException {
        Pessoa pessoa = _pessoaService.get(pessoaId);
        return _enderecoRepository.findByPessoaId(pessoa.getId());
    }

    public Endereco get(UUID pessoaId, UUID enderecoId) throws ResourceNotFoundException{
        Optional<Endereco> optionalEndereco = _enderecoRepository.findById(enderecoId);
        if (!optionalEndereco.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return optionalEndereco.get();
    }

    public Endereco update(UUID pessoaId, UUID enderecoId, Endereco endereco) throws ResourceNotFoundException {
        Endereco e = get(pessoaId, enderecoId);
        e.setLogradouro(endereco.getLogradouro());
        e.setBairro(endereco.getBairro());
        e.setComplemento(endereco.getComplemento());
        e.setDescricao(endereco.getDescricao());
        return _enderecoRepository.save(e);
    }

    public void delete(UUID pessoaId, UUID enderecoId) throws ResourceNotFoundException{
        Endereco e = get(pessoaId, enderecoId);
        _enderecoRepository.delete(e);
    }
}

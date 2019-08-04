package com.fsantos.jurisoft.service.pessoa;

import com.fsantos.jurisoft.exception.ResourceNotFoundException;
import com.fsantos.jurisoft.model.pessoa.Pessoa;
import com.fsantos.jurisoft.repository.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository _pessoaRepository;

    public Page<Pessoa> get(Pageable page){ return _pessoaRepository.findAll(page); }

    public Pessoa get(UUID id) throws ResourceNotFoundException {
        Optional<Pessoa> optionalPessoa = _pessoaRepository.findById(id);
        if (!optionalPessoa.isPresent()) {
            throw new ResourceNotFoundException("Recurso " + id + " não encontrado");
        }
        return optionalPessoa.get();
    }

    public Pessoa save(Pessoa pessoa){
        Pessoa salva = _pessoaRepository.save(pessoa);
        return salva;
    }

    public Pessoa update(UUID pessoaId, Pessoa pessoa) throws ResourceNotFoundException {
        Optional<Pessoa> optionalPessoa = _pessoaRepository.findById(pessoaId);
        if(!optionalPessoa.isPresent()){
            throw new ResourceNotFoundException("Recurso " +  pessoaId + " a ser editado não encontrado");
        }
        Pessoa p = optionalPessoa.get();
        p.setNome(pessoa.getNome());
        p.setCpf(pessoa.getCpf());
        p.setRg(pessoa.getRg());
        p.setCarteiraDeTrabalho(pessoa.getCarteiraDeTrabalho());
        p.setPis(pessoa.getPis());
        p.setProfissao(pessoa.getProfissao());
        p.setDataDeNascimento(pessoa.getDataDeNascimento());
        p.setSexo(p.getSexo());
        return _pessoaRepository.save(p);

    }

    public void delete(UUID id) throws ResourceNotFoundException {
        Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
        if(!pessoa.isPresent()){
            throw new ResourceNotFoundException("Recurso " + id + " a ser deletado não encontrado");
        }
        _pessoaRepository.delete(pessoa.get());
    }

    public boolean existsById(UUID pessoaId) throws ResourceNotFoundException {
        if (!_pessoaRepository.existsById(pessoaId)){
            throw new ResourceNotFoundException();
        }
        return true;
    }
}

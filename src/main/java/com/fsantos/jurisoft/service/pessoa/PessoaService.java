package com.fsantos.jurisoft.service.pessoa;

import com.fsantos.jurisoft.exception.ResourceNotFoundException;
import com.fsantos.jurisoft.model.pessoa.Pessoa;
import com.fsantos.jurisoft.repository.pessoa.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ModelMapper mapper;

    public Page<Pessoa> get(Pageable page){ return pessoaRepository.findAll(page); }

    public Pessoa get(UUID id) throws ResourceNotFoundException {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        if (!optionalPessoa.isPresent()) {
            throw new ResourceNotFoundException("Recurso " + id + " não encontrado");
        }
        return optionalPessoa.get();
    }

    public Pessoa save(Pessoa pessoa){
        Pessoa salva = pessoaRepository.save(pessoa);
        return salva;
    }

    public Pessoa update(UUID pessoaId, Pessoa pessoa) throws ResourceNotFoundException {
            Pessoa p = get(pessoaId);
            this.mapper.map(pessoa, p);
            return this.pessoaRepository.save(p);
    }

    public void delete(UUID id) throws ResourceNotFoundException {
        Pessoa p = get(id);
        p.setDeleted(true);
        pessoaRepository.save(p);
    }

    public boolean existsById(UUID pessoaId) throws ResourceNotFoundException {
        if (!pessoaRepository.existsById(pessoaId)){
            throw new ResourceNotFoundException();
        }
        return true;
    }
}

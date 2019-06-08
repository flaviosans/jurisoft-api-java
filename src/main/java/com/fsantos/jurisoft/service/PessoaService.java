package com.fsantos.jurisoft.service;

import com.fsantos.jurisoft.model.Pessoa.Pessoa;
import com.fsantos.jurisoft.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository _PessoaRepository;

    public Page<Pessoa> findAll(Pageable page){
        return _PessoaRepository.findAll(page);
    }
}
package com.fsantos.jurisoft.controller.pessoa;

import com.fsantos.jurisoft.exception.ResourceNotFoundException;
import com.fsantos.jurisoft.model.pessoa.Pessoa;
import com.fsantos.jurisoft.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "http://localhost:4200")
public class PessoaController {

    @Autowired
    private PessoaService _pessoaService;

    @GetMapping
    public Page<Pessoa> getPessoas(Pageable page){
        return _pessoaService.get(page);
    }

    @GetMapping("/{pessoaId}")
    public Pessoa getPessoa(@PathVariable UUID pessoaId) throws ResourceNotFoundException {
        return _pessoaService.get(pessoaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa create(@RequestBody Pessoa pessoa){
        return _pessoaService.save(pessoa);
    }

    @PutMapping("/{pessoaId}")
    public Pessoa update(@PathVariable UUID pessoaId, @RequestBody Pessoa pessoa) throws ResourceNotFoundException{
        return _pessoaService.update(pessoaId, pessoa);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(UUID id) throws ResourceNotFoundException {
        _pessoaService.delete(id);
    }

}

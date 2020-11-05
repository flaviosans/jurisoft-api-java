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
    private PessoaService pessoaService;

    @GetMapping
    public Page<Pessoa> getPessoas(Pageable page){
        return pessoaService.get(page);
    }

    @GetMapping("/{pessoaId}")
    public Pessoa getPessoa(@PathVariable UUID pessoaId) throws ResourceNotFoundException {
        return pessoaService.get(pessoaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa create(@RequestBody Pessoa pessoa){
        return pessoaService.save(pessoa);
    }

    @PutMapping("/{pessoaId}")
    public Pessoa update(@PathVariable UUID pessoaId, @RequestBody Pessoa pessoa) throws ResourceNotFoundException{
        return pessoaService.update(pessoaId, pessoa);
    }

    @DeleteMapping("/{pessoaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID pessoaId) throws ResourceNotFoundException {
        pessoaService.delete(pessoaId);
    }
}

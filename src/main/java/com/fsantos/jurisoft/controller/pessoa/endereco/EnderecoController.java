package com.fsantos.jurisoft.controller.pessoa.endereco;

import com.fsantos.jurisoft.exception.ResourceNotFoundException;
import com.fsantos.jurisoft.model.pessoa.endereco.Endereco;
import com.fsantos.jurisoft.service.pessoa.endereco.EnderecoService;
import com.fsantos.jurisoft.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/pessoa/{pessoaId}/endereco")
@CrossOrigin(origins = "http://localhost:4200")
public class EnderecoController {
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public Set<Endereco> getEnderecos(@PathVariable UUID pessoaId) throws ResourceNotFoundException {
        return enderecoService.get(pessoaId);
    }

    @GetMapping("/{enderecoId}")
    public Endereco getEndereco(@PathVariable UUID pessoaId,@PathVariable UUID enderecoId) throws ResourceNotFoundException {
        return enderecoService.get(pessoaId, enderecoId);
    }

    @PostMapping
    public Endereco create(@PathVariable UUID pessoaId, @RequestBody Endereco endereco) throws ResourceNotFoundException {
        return enderecoService.save(pessoaId, endereco);
    }

    @PutMapping("/{enderecoId}")
    public Endereco update(@PathVariable UUID pessoaId, @PathVariable UUID enderecoId, @RequestBody Endereco endereco) throws ResourceNotFoundException {
        return enderecoService.update(pessoaId, enderecoId, endereco);
    }

    @DeleteMapping("/{enderecoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID pessoaId, @PathVariable UUID enderecoId) throws ResourceNotFoundException{
        enderecoService.delete(pessoaId, enderecoId);
    }
}

package com.fsantos.jurisoft.controller.pessoa;

import com.fsantos.jurisoft.exception.ResourceNotFoundException;
import com.fsantos.jurisoft.model.pessoa.Telefone;
import com.fsantos.jurisoft.service.pessoa.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;


@RestController
@RequestMapping("/pessoa/{pessoaId}/telefone")
@CrossOrigin(origins = "http://localhost:4200")
public class TelefoneController {
    @Autowired
    private TelefoneService _telefoneService;

    @GetMapping
    public Set<Telefone> getTelefones(@PathVariable UUID pessoaId) throws ResourceNotFoundException{
        return _telefoneService.get(pessoaId);
    }

    @GetMapping("/{telefoneId")
    public Telefone getTelefone(@PathVariable UUID pessoaId, @PathVariable UUID telefoneId) throws ResourceNotFoundException {
        return _telefoneService.get(pessoaId, telefoneId);
    }

    @PostMapping
    public Telefone create(@PathVariable UUID pessoaId, @RequestBody Telefone telefone) throws ResourceNotFoundException {
        return _telefoneService.save(pessoaId, telefone);
    }

    @PutMapping("/{telefoneId}")
    public Telefone update(@PathVariable UUID pessoaId, @PathVariable UUID telefoneId, @RequestBody Telefone telefone) throws ResourceNotFoundException {
        return _telefoneService.update(pessoaId, telefoneId, telefone);
    }

    @DeleteMapping("/{telefoneId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID pessoaId, @PathVariable UUID telefoneId) throws ResourceNotFoundException {
        _telefoneService.delete(pessoaId, telefoneId);
    }
}

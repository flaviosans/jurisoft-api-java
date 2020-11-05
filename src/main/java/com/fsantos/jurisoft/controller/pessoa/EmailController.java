package com.fsantos.jurisoft.controller.pessoa;

import com.fsantos.jurisoft.exception.ResourceNotFoundException;
import com.fsantos.jurisoft.model.pessoa.Email;
import com.fsantos.jurisoft.service.pessoa.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/pessoa/{pessoaId}/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping
    public Set<Email> getEmails(@PathVariable UUID pessoaId) throws ResourceNotFoundException{
        return emailService.get(pessoaId);
    }

    @GetMapping("/{emailId}")
    public Email getEmail(@PathVariable UUID pessoaId, @PathVariable UUID emailId) throws ResourceNotFoundException{
        return emailService.get(pessoaId, emailId);
    }

    @PostMapping
    public Email create(@PathVariable UUID pessoaId, @RequestBody Email email) throws ResourceNotFoundException{
        return emailService.save(pessoaId, email);
    }

    @PutMapping("/{emailId}")
    public Email update(@PathVariable UUID pessoaId, @PathVariable UUID emailId, @RequestBody Email email) throws ResourceNotFoundException{
        return emailService.update(pessoaId, emailId, email);
    }

    @DeleteMapping("/{emailId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID pessoaId, @PathVariable UUID emailId) throws ResourceNotFoundException{
        emailService.delete(pessoaId, emailId);
    }
}

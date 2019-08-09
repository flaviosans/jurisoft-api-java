package com.fsantos.jurisoft.controller.pessoa;

import com.fsantos.jurisoft.enumerable.Sexo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/sexo")
@CrossOrigin(origins = "http://localhost:4200")
public class SexoController {
//    @Autowired
//    private Sexo Sexo;

    @GetMapping
    public Set<Sexo> getSexo(){
        return null;
    }
}

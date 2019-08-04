package com.fsantos.jurisoft.model.processo.questionario;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Detalhe {

    @Id @GeneratedValue
    private UUID id;

   @ManyToOne
   @JoinColumn(name = "alternativa_id")
    private Alternativa alternativa;
}

package com.fsantos.jurisoft.config;

import com.fsantos.jurisoft.model.pessoa.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Pessoa.class, Pessoa.class)
                .addMappings(m -> m.skip(Pessoa::setId));
        return modelMapper;
    }
}

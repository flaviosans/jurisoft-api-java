package com.fsantos.jurisoft.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class ApplicationConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}

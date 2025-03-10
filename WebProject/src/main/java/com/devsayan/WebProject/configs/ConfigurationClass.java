package com.devsayan.WebProject.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {

    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}

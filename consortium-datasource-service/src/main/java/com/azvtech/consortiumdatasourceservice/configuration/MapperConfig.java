package com.azvtech.consortiumdatasourceservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Fellipe Toledo
 */
@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modalMapper() {
        return new ModelMapper();
    }
}

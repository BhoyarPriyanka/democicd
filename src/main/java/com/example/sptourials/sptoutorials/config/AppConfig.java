package com.example.sptourials.sptoutorials.config;

import com.example.sptourials.sptoutorials.DB;
import com.example.sptourials.sptoutorials.DevDB;
import com.example.sptourials.sptoutorials.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name="project.db",havingValue = "dev")
    public DB getDevDB()
    {
        return new DevDB();
    }
    @Bean
    @ConditionalOnProperty(name="project.db",havingValue = "prod")
    public DB getProdDB() {
        return new ProdDB();
    }
    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }

}

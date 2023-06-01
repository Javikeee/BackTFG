package com.profilePract.example.postgresql.config;

import com.profilePract.example.postgresql.mapper.ObjectMapper;
import com.profilePract.example.postgresql.mapper.OrikaObjectMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Optional;

@Configuration
public class OrikaConfiguration {
    @Bean("orikaMapper")
    @Primary
    public ObjectMapper orikaObjectMapper(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        return new OrikaObjectMapper(Optional.of(mapperFactory));
    }
}
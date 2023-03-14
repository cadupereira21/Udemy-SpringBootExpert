package io.github.m4nko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* Classe escaneada pelo spring boot como cnfiguração
*
* Configurações são feitas através de Beans;
*
* */
@Configuration
public class AppConfiguration {
    @Bean(name = "appName")
    public String appName(){
        return "Sistema de Vendas";
    }

}

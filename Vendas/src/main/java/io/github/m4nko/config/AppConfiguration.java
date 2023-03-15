package io.github.m4nko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
* Classe escaneada pelo spring boot como cnfiguração
*
* Configurações são feitas através de Beans;
*
* */
@Configuration
@Profile("production") // Anotação que fará com que esse arquivo de configuração só funcione quando o perfil ativo for production
public class AppConfiguration {
//    @Bean(name = "appName")
//    public String appName(){
//        return "Sistema de Vendas";
//    }

}

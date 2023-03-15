package io.github.m4nko.config;

import org.springframework.boot.CommandLineRunner;
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
//@Profile("production") // Anotação que fará com que esse arquivo de configuração só funcione quando o perfil ativo for production
@Production // Anotação personalizada que substitui a anotação acima
public class AppConfiguration {
//    @Bean(name = "appName")
//    public String appName(){
//        return "Sistema de Vendas";
//    }
    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("RODANDO CONFIGURAÇÃO DE PRODUÇÃO");
        };
    }
}

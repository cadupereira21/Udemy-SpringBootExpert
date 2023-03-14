package io.github.m4nko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
/*
@ComponentScan(basePackages = {
        "io.github.m4nko.config",
        "io.github.m4nko.controller"
        }) // Anotação para que o Spring Boot mantenha tracking dos nossos pacotes do MVC (Repository, Service, Controller) no container
           // OBS: Spring boot já mantem o tracking de todos os pacotes e classes a partir do pacote em que está definido o "@SpringBootApplication"*/
@RestController
public class VendasApplication {

    @Autowired
    @Qualifier("appName")
    private String appName; // Variável referente à configuração na classe AppConfiguration -> appName()

    @GetMapping("/hello")
    public String helloWorld(){
        return appName;
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

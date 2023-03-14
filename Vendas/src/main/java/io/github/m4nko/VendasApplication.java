package io.github.m4nko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
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

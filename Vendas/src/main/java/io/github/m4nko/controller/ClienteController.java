package io.github.m4nko.controller;

import io.github.m4nko.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {
    @RequestMapping(
            value = {"/hello/{nome}", "/api/hello"}, // Recebe array de strings para definição de várias rotas
            method = RequestMethod.GET,
            consumes = {"application/json", "application/xml"}, // Tipo de dados recebidos / esperados
            produces = {"application/json", "application/xml"} // Tipo de dados enviados
    )

    @ResponseBody
    public String helloClientes(@PathVariable("nome") String nomeCliente, @RequestBody Cliente cliente){ // Parâmetro com anotação @RequestBody diz ao Spring para esperar no corpo da requisição um objeto Cliente (no formato JSON ou XML conforme parâmetro consume)
        return String.format("Hello %s", nomeCliente);
    }
}

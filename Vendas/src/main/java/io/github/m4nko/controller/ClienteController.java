package io.github.m4nko.controller;

import io.github.m4nko.model.Cliente;
import io.github.m4nko.repository.ClienteRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController // Anotação especializada, eliminando a necessidade do Response Body
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/{id}") // Equivalente ao @RequestMapping com método get
    //@ResponseBody
    public Cliente getClienteById(@PathVariable Integer id){ // Parâmetro com anotação @RequestBody diz ao Spring para esperar no corpo da requisição um objeto Cliente (no formato JSON ou XML conforme parâmetro consume)
        return clienteRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        /* Na expressão acima o controller irá retornar um statis 200 caso findById() retorne um cliente
        * mas irá jogar um ResponseStatusException de código 404 caso não dẽ certo, com a mensagem "Cliente não encontrado*/
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Modifica o retorno http padrão (cod 200)
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable Integer id){
            var result = clienteRepository.findById(id)
                    .orElseThrow(() ->
                            new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

            clienteRepository.delete(result);
    }

    @PutMapping("/{id}") // Qualquer dado enviado como nulo será atualizado para nulo na base (Update integral)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente){
        clienteRepository
                .findById(id)
                .map(clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clienteRepository.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }
}



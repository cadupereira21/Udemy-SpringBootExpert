package io.github.m4nko.controller;

import io.github.m4nko.model.Cliente;
import io.github.m4nko.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/{id}") // Equivalente ao @RequestMapping com método get
    //@ResponseBody
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id){ // Parâmetro com anotação @RequestBody diz ao Spring para esperar no corpo da requisição um objeto Cliente (no formato JSON ou XML conforme parâmetro consume)
        Optional<Cliente> result = clienteRepository.findById(id);

        if(result.isPresent()) return ResponseEntity.ok(result.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity saveCliente(@RequestBody Cliente cliente){
        Cliente result = clienteRepository.save(cliente);
        return ResponseEntity.ok(result);
    }
}



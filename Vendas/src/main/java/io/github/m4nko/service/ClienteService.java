package io.github.m4nko.service;

import io.github.m4nko.model.Cliente;
import io.github.m4nko.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Injeção de dependência = Criar uma instância de ClienteRepository como atributo de Cliente Service e colocar o @Autowired para que o SpringBoot possa pegar a instância no container, uma vez que ClienteRepository possui a notação @Repository
// OBS: Pode ser injetada pelo construtor (Exemplo abaixo), via setter ou diretamente no atributo apenas modificando o local da notação @Autowired
// OBS 2: Ao injetar no construtor e a classe estar com a notação @Service, pode-se omitir o @Autowired
@Service
public class ClienteService {

    private ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void SalvarCliente(Cliente cliente){
        ValidarCliente(cliente);
        // ClienteRepository clienteRepository = new ClienteRepository(); // Não interessante de fazer, uma vez que ficar acessando a base em tempo de execução pode estourar a base
        repository.persistir(cliente);
    }

    public void ValidarCliente(Cliente cliente){

    }
}

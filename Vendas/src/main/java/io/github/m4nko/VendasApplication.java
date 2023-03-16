package io.github.m4nko;

import io.github.m4nko.model.Cliente;
import io.github.m4nko.model.Pedido;
import io.github.m4nko.repository.ClienteRepository;
import io.github.m4nko.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.lang.ref.Cleaner;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired ClienteRepository clienteRepository,
            @Autowired PedidoRepository pedidoRepository){
        return args -> {
            Cliente cliente = new Cliente("Carlos");
            clienteRepository.save(cliente);
            Cliente cliente2 = new Cliente("Clara");
            clienteRepository.save(cliente2);

            Pedido p = new Pedido();
            p.setCliente(cliente);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));
            pedidoRepository.save(p);

//            Cliente result = clienteRepository.findClienteFetchPedidos(cliente.getId());
//            System.out.println(result);
//            System.out.println(result.getPedidos());
            pedidoRepository.findByCliente(cliente).forEach(System.out::println); // Mesmo que código comentado acima
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

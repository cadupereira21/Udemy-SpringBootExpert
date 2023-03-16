package io.github.m4nko.repository;

import io.github.m4nko.model.Cliente;
import io.github.m4nko.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente); // Como cliente é um atributo de Pedido podemos fazer com query method
}

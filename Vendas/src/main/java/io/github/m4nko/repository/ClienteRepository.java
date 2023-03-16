package io.github.m4nko.repository;

import io.github.m4nko.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String nome);
    boolean existsByNome(String nome);
}

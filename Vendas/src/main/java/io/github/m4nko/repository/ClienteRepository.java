package io.github.m4nko.repository;

import io.github.m4nko.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value="select * from CLIENTE c where c.nome like '%:nome%'", nativeQuery = true) // nativeQuery para dizer que é uma consulta SQL nativa
    List<Cliente> encontrarPorNome(@Param("nome") String nome);
    boolean existsByNome(String nome);

    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}

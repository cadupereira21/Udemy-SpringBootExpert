package io.github.m4nko.repository;

import io.github.m4nko.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClienteRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional // Anota que esse método será uma transação na base
    public Cliente salvar(Cliente cliente){
        entityManager.persist(cliente);
        return cliente;
    }
}

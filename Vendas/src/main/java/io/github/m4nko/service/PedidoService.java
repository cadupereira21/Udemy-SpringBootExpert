package io.github.m4nko.service;

import io.github.m4nko.domain.entity.Pedido;
import io.github.m4nko.domain.enums.StatusPedido;
import io.github.m4nko.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}

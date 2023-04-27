package io.github.m4nko.rest.controller;

import io.github.m4nko.domain.entity.Usuario;
import io.github.m4nko.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl service;
    private final PasswordEncoder pwdEncoder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario){
        String senhaCriptografada = pwdEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return service.salvar(usuario);
    }
}

package com.am.hambuqueria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.am.hambuqueria.api.dto.mapper.UsuarioMapperDTO;
import com.am.hambuqueria.api.dto.response.UsuarioResponseDTO;
import com.am.hambuqueria.domain.model.Usuario;
import com.am.hambuqueria.domain.service.UsuarioService;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@RestController
@AllArgsConstructor
@RequestMapping(value = "/usuario")
public class UsuarioController {
    private final UsuarioMapperDTO mapper;
    private final UsuarioService service;

    // ESSA CLASSE TA ERRADA ( Return erro bad request code 500)
    @GetMapping
    public ResponseEntity<UsuarioResponseDTO> listar() {
        Usuario usuario = (Usuario) service.todos();
        final UsuarioResponseDTO usuarioResponseDTO = mapper.toResponse(usuario);
        return new ResponseEntity<>(usuarioResponseDTO, HttpStatus.OK);
    }

    /*
     * @GetMapping("{id}")
     * public Optional<UsuarioResponseDTO> listaUsuarioPorId(@RequestParam(value =
     * "id") long id) {
     * List<Usuario> usuario = service.buscaPor(id);
     * List<UsuarioResponseDTO> usuarioResponse = mapper.toResponseList(usuario);
     * return usuarioResponse;
     * }
     */
}

package com.am.hambuqueria.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @GetMapping("/todos")
    public List<UsuarioResponseDTO> listar() {
        List<Usuario> usuario = service.todos();
        List<UsuarioResponseDTO> usuarioResponseDTO = mapper.toResponseList(usuario);
        return usuarioResponseDTO;
    }

    
    @GetMapping("buscar/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@RequestParam(value = "id") long id) {
        Usuario usuario = service.buscaPor(id);
        final UsuarioResponseDTO usuarioResponseDTO = mapper.toResponse(usuario);
        return new ResponseEntity<>(usuarioResponseDTO, HttpStatus.OK);
    }
     
    @GetMapping("buscar/{nome}")
    public ResponseEntity<List<UsuarioResponseDTO>> buscarPorNome(@RequestParam(value = "nome") String nome){
        List<Usuario> usuario = service.buscaPorNome(nome);
        List<UsuarioResponseDTO> usuarioResponseDTO = mapper.toResponseList(usuario);
        return new ResponseEntity<>(usuarioResponseDTO, HttpStatus.OK);
    }

    // This function return erro bad request code 500, i need to resolve this
    @GetMapping("buscar/paginada/{nome}")
    public ResponseEntity<Page<UsuarioResponseDTO>> buscarPorNomePaginada(@RequestParam(value = "nome") String nome, Pageable paginacao){
        Page<Usuario> usuarioPaginado = service.buscaPorNome(nome, paginacao);
        final Page<UsuarioResponseDTO> listUsuarioResponseDTOPaginada = (usuarioPaginado.map(usuario -> mapper.toResponse(usuario)));
        return new ResponseEntity<>(listUsuarioResponseDTOPaginada, HttpStatus.OK);
    }

    @GetMapping("buscar/{email}")
    public ResponseEntity<List<UsuarioResponseDTO>> buscarPorEmail(@RequestParam(value = "email") String email){
        List<Usuario> usuario = service.buscaPorEmail(email);
        List<UsuarioResponseDTO> usuarioResponseDTO = mapper.toResponseList(usuario);
        return new ResponseEntity<>(usuarioResponseDTO, HttpStatus.OK);
    }
}

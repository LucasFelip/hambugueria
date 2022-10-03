package com.am.hambuqueria.api.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.am.hambuqueria.api.dto.request.UsuarioRequestDTO;
import com.am.hambuqueria.api.dto.response.UsuarioResponseDTO;
import com.am.hambuqueria.domain.model.Usuario;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UsuarioMapperDTO {
    private final ModelMapper modelMapper;

    public Usuario toEntity(UsuarioRequestDTO usuarioRequest) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(usuarioRequest, Usuario.class);
    }

    public UsuarioResponseDTO toResponse(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioResponseDTO.class);
    }

    public List<Usuario> toEntityList(List<UsuarioRequestDTO> listaUsuarioRequest) {
        return listaUsuarioRequest.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public List<UsuarioResponseDTO> toResponseList(List<Usuario> listaUsuario) {
        return listaUsuario.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}

package com.am.hambuqueria.api.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UsuarioRequestDTO {
    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private String nome;
}

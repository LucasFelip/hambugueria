package com.am.hambuqueria.api.dto.response;

import lombok.Data;

@Data
public class UsuarioRespondeDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
}

package com.am.hambuqueria.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AberturaController {
    @GetMapping
    public String imobiliaria() {
        String url = "https://github.com/LucasFelip";
        return "BEM VINDO A API DE HAMBURGUERIA                    → Desenvolvido por Lucas Felipe " + url;
    }
}

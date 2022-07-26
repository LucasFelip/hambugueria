package com.am.hambuqueria.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.am.hambuqueria.domain.exception.NegocioException;
import com.am.hambuqueria.domain.model.Usuario;
import com.am.hambuqueria.domain.repository.UsuarioRepository;

import lombok.Builder;

@Builder
@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    // operações de busca
    public List<Usuario> todos() {
        return repository.findAll();
    }

    public Usuario buscaPor(Long id) {
        Usuario usuario = repository.findById(id).get();
        return usuario;
    }

    public List<Usuario> buscaPorEmail(String email) {
        if (repository.findByEmailContainsIgnoreCase(email) == null)
            throw new NegocioException("Não existe nenhum usuario cadastrado com este e-mail.");
        return repository.findByEmailContainsIgnoreCase(email);
    }

    public List<Usuario> buscaPorNome(String nome) {
        if (repository.findByNomeContainsIgnoreCase(nome) == null)
            throw new NegocioException("Não existe nenhum usuario cadastrado com este e-mail.");
        return repository.findByNomeContainsIgnoreCase(nome);
    }

    public Page<Usuario> buscaPorNome(String nome, Pageable pageable) {
        if (repository.findByNomeContainsIgnoreCase(nome) == null)
            throw new NegocioException("Não existe nenhum usuario cadastrado com este e-mail.");
        return repository.findByNomeContainsIgnoreCase(nome, pageable);
    }

    // operações de inserção
    @Transactional
    public Usuario salva(Usuario usuario) {
        List<Usuario> emailEmUso = repository.findByEmailContainsIgnoreCase(usuario.getEmail());
        if (emailEmUso != null)
            throw new NegocioException("Já existe um usuario cadastrado com este e-mail.");
        return repository.save(usuario);
    }

    public Usuario atualiza(Usuario usuario, Long id) {
        if (repository.findById(id) == null)
            throw new NegocioException("Não existe nenhum usuario cadastrado com este id.");
        return salva(usuario);
    }

    // operações de remoção
    @Transactional
    public void removePelo(Long id) {
        repository.deleteById(id);
    }

    public boolean naoExisteCom(Long id) {
        return !repository.existsById(id);
    }
}

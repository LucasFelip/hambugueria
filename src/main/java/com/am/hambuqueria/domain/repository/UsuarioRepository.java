package com.am.hambuqueria.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.am.hambuqueria.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findById(Long id);

    List<Usuario> findByNomeContainsIgnoreCase(String nome);

    List<Usuario> findByEmailContainsIgnoreCase(String email);

    Page<Usuario> findByNomeContainsIgnoreCase(String nome, Pageable paginacao);
}

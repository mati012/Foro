package com.example.foro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foro.model.publicaciones;

public interface publicacionesRepository extends JpaRepository<publicaciones, Long> {

    List<publicaciones> findByTopicoId(Long topicoId);
    
    List<publicaciones> findByTituloContainingIgnoreCase(String titulo);
    
    List<publicaciones> findByAutorId(Long autorId);
}

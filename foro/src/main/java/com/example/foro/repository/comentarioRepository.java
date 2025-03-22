package com.example.foro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foro.model.comentario;

public interface comentarioRepository extends JpaRepository<comentario, Long> {
    
    List<comentario> findByPostId(Long postId);
    
    List<comentario> findByAutorId(Long autorId);
}

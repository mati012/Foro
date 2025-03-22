package com.example.foro.repository;

import com.example.foro.model.topico;
import com.example.foro.dto.topicoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface topicoRepository extends JpaRepository<topico, Long> {
    
    @Query("SELECT new com.example.foro.dto.topicoDto(t.id, t.nombre, t.descripcion) FROM topico t")
    List<topicoDto> findAllTopicos();
}
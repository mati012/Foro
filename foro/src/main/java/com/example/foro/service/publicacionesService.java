package com.example.foro.service;

import java.util.List;
import java.util.Optional;

import com.example.foro.dto.PublicacionesDto;
import com.example.foro.model.publicaciones;

public interface publicacionesService {
    publicaciones createPublicacion(publicaciones publicacion);
    void deletePublicacion(Long id);
    Optional<PublicacionesDto> getPublicacion(Long id);
    List<PublicacionesDto> getPublicaciones();
}
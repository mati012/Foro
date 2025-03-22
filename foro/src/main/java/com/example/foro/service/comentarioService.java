package com.example.foro.service;

import java.util.List;
import java.util.Optional;

import com.example.foro.dto.comentarioDto;

public interface comentarioService {
    List<comentarioDto> getAll();
    Optional<comentarioDto> getOne(Long id);
    comentarioDto agregarComentario(comentarioDto comentarioDto);
    comentarioDto actualizarComentario(Long id, comentarioDto comentarioDto);
    void eliminarComentario(Long id);
}

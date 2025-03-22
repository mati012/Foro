package com.example.foro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foro.repository.publicacionesRepository;
import com.example.foro.dto.PublicacionesDto;
import com.example.foro.model.publicaciones;

import jakarta.transaction.Transactional;

@Service
public class publicacionesServiceImpl implements publicacionesService {
    
    private final publicacionesRepository publicacionesRepository;
    
    @Autowired
    public publicacionesServiceImpl(publicacionesRepository publicacionesRepository) {
        this.publicacionesRepository = publicacionesRepository;
    }
    
    @Override
    @Transactional
    public publicaciones createPublicacion(publicaciones publicacion) {
        return publicacionesRepository.save(publicacion);
    }
    
    @Override
    @Transactional
    public void deletePublicacion(Long id) {
        publicacionesRepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public Optional<PublicacionesDto> getPublicacion(Long id) {
        return publicacionesRepository.findById(id)
                .map(this::convertToDto);
    }
    
    @Override
    @Transactional
    public List<PublicacionesDto> getPublicaciones() {
        return publicacionesRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    private PublicacionesDto convertToDto(publicaciones publicacion) {
        return new PublicacionesDto(
            publicacion.getId(),
            publicacion.getTitulo(),
            publicacion.getContenido(),
            publicacion.getFechaCreacion(),
            publicacion.getAutor(),
            publicacion.getTopico() != null ? publicacion.getTopico().getId() : null,
            publicacion.getTopico() != null ? publicacion.getTopico().getNombre() : null
        );
    }
}
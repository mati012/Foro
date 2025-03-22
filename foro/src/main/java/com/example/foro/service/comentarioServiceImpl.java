package com.example.foro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foro.dto.comentarioDto;
import com.example.foro.model.comentario;
import com.example.foro.model.publicaciones;
import com.example.foro.repository.comentarioRepository;
import com.example.foro.repository.publicacionesRepository;

import jakarta.transaction.Transactional;
@Service
public class comentarioServiceImpl implements comentarioService {

    @Autowired
    private comentarioRepository comentarioRepository;
    
    @Autowired
    private publicacionesRepository publicacionesRepository;
    
    
    @Override
    public List<comentarioDto> getAll() {
        List<comentario> comentarios = comentarioRepository.findAll();
        return comentarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<comentarioDto> getOne(Long id) {
        return comentarioRepository.findById(id)
                .map(this::convertToDTO);
    }
    @Override
    public comentarioDto agregarComentario(comentarioDto comentarioDTO) {
        publicaciones publicacion = publicacionesRepository.findById(comentarioDTO.getPost_id())
            .orElseThrow(() -> new RuntimeException("Publicación no encontrada con ID: " + comentarioDTO.getPost_id()));
        
        comentario nuevoComentario = new comentario();
        nuevoComentario.setMensaje(comentarioDTO.getMensaje());
        nuevoComentario.setPost(publicacion);
        

        
        comentario guardado = comentarioRepository.save(nuevoComentario);
        
        return convertToDTO(guardado);
    }
    
    private comentarioDto convertToDTO(comentario entidad) {
        comentarioDto dto = new comentarioDto();
        dto.setId(entidad.getId());
        dto.setMensaje(entidad.getMensaje());
        
        if (entidad.getPost() != null) {
            dto.setPost_id(entidad.getPost().getId());
        }
        
        dto.setAutorId(entidad.getAutorId());
        
        return dto;
    }
    
    
    @Override
    public comentarioDto actualizarComentario(Long id, comentarioDto comentarioDTO) {
      
        Optional<comentario> comentarioOpt = comentarioRepository.findById(id);
        if (!comentarioOpt.isPresent()) {
            throw new RuntimeException("Comentario no encontrado con ID: " + id);
        }
        
        comentario comentarioExistente = comentarioOpt.get();
        
        if (comentarioDTO.getMensaje() != null) {
            comentarioExistente.setMensaje(comentarioDTO.getMensaje());
        }
        
        if (comentarioDTO.getPost_id() != null) {
            Optional<publicaciones> publicacionOpt = publicacionesRepository.findById(comentarioDTO.getPost_id());
            if (publicacionOpt.isPresent()) {
                comentarioExistente.setPost(publicacionOpt.get());
            } else {
                throw new RuntimeException("Publicación no encontrada con ID: " + comentarioDTO.getPost_id());
            }
        }
        
        comentario actualizado = comentarioRepository.save(comentarioExistente);
        
        return convertToDTO(actualizado);
    }
    
    @Override
    public void eliminarComentario(Long id) {
        if (!comentarioRepository.existsById(id)) {
            throw new RuntimeException("Comentario no encontrado con ID: " + id);
        }
        comentarioRepository.deleteById(id);
    }
    

}
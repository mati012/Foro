package com.example.foro.service;

import com.example.foro.dto.topicoDto;
import com.example.foro.model.topico;
import com.example.foro.repository.topicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class topicoServiceImpl implements topicoService {
    private final topicoRepository topicoRepository;
    
    public topicoServiceImpl(topicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }
    
    @Override
    public List<topicoDto> getAllTopicos() {
        return topicoRepository.findAllTopicos();
    }
    
    @Override
    public topicoDto getTopicoById(Long id) {
        topico entity = topicoRepository.findById(id).orElse(null);
        if (entity == null) {
            return null;
        }
        return convertToDto(entity);
    }
    
    private topicoDto convertToDto(topico entity) {
        return new topicoDto(
            entity.getId(),
            entity.getNombre(),
            entity.getDescripcion()
        );
    }
}
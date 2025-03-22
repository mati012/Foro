package com.example.foro.service;
import com.example.foro.dto.topicoDto;

import java.util.List;

public interface topicoService {
    List<topicoDto> getAllTopicos();
    topicoDto getTopicoById(Long id);
}

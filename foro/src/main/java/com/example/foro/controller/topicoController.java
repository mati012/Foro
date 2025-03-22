package com.example.foro.controller;

import com.example.foro.dto.topicoDto;
import com.example.foro.service.topicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class topicoController {

    private final topicoService topicoService;

    public topicoController(topicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping
    public ResponseEntity<List<topicoDto>> getAllTopicos() {
        return ResponseEntity.ok(topicoService.getAllTopicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<topicoDto> getTopico(@PathVariable Long id) {
        topicoDto topico = topicoService.getTopicoById(id);
        return topico != null ? ResponseEntity.ok(topico) : ResponseEntity.notFound().build();
    }
}

package com.example.foro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.foro.dto.PublicacionesDto;
import com.example.foro.model.publicaciones;
import com.example.foro.service.publicacionesService;

@RestController
@RequestMapping("/publicaciones")
public class publicacionesController {

    private final publicacionesService publicacionesService;

    @Autowired
    public publicacionesController(publicacionesService publicacionesService) {
        this.publicacionesService = publicacionesService;
    }

    @GetMapping
    public ResponseEntity<List<PublicacionesDto>> getAllPublicaciones() {
        return ResponseEntity.ok(publicacionesService.getPublicaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionesDto> getPublicacion(@PathVariable Long id) {
        Optional<PublicacionesDto> publicacion = publicacionesService.getPublicacion(id);
        return publicacion.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<publicaciones> createPublicacion(@RequestBody publicaciones publicacion) {
        return ResponseEntity.ok(publicacionesService.createPublicacion(publicacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublicacion(@PathVariable Long id) {
        publicacionesService.deletePublicacion(id);
        return ResponseEntity.noContent().build();
    }
}
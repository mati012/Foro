package com.example.foro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.foro.dto.comentarioDto;
import com.example.foro.service.comentarioService;

@RestController
@RequestMapping("/comentarios")
public class comentarioController {

    private final comentarioService comentarioService;

    @Autowired
    public comentarioController(comentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public ResponseEntity<List<comentarioDto>> getAllComentarios() {
        return ResponseEntity.ok(comentarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<comentarioDto> getComentario(@PathVariable Long id) {
        Optional<comentarioDto> comentario = comentarioService.getOne(id);
        return comentario.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<comentarioDto> agregarComentario(@RequestBody comentarioDto comentarioDTO) {
        return ResponseEntity.ok(comentarioService.agregarComentario(comentarioDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<comentarioDto> actualizarComentario(@PathVariable Long id, @RequestBody comentarioDto comentarioDTO) {
        return ResponseEntity.ok(comentarioService.actualizarComentario(id, comentarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
        return ResponseEntity.noContent().build();
    }
}

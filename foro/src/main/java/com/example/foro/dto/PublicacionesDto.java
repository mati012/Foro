package com.example.foro.dto;

import java.time.LocalDateTime;

public class PublicacionesDto {
    private Long id;
    private String titulo;
    private String contenido;
    private LocalDateTime fechaCreacion;
    private String autor;
    private Long topicoId;
    private String topicoNombre;
    
    public PublicacionesDto() {
    }
    
    public PublicacionesDto(Long id, String titulo, String contenido, 
                           LocalDateTime fechaCreacion, String autor, 
                           Long topicoId, String topicoNombre) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.autor = autor;
        this.topicoId = topicoId;
        this.topicoNombre = topicoNombre;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getContenido() {
        return contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public Long getTopicoId() {
        return topicoId;
    }
    
    public void setTopicoId(Long topicoId) {
        this.topicoId = topicoId;
    }
    
    public String getTopicoNombre() {
        return topicoNombre;
    }
    
    public void setTopicoNombre(String topicoNombre) {
        this.topicoNombre = topicoNombre;
    }
    
}
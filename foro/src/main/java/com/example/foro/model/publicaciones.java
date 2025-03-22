package com.example.foro.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "publicaciones")
public class publicaciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String contenido;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name = "topico_id")
    private topico topico;
    
    private String autor;
    private Long autorId;   


    
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<comentario> comentarios;

    public publicaciones() {
    }
    
    public publicaciones(String titulo, String contenido, topico topico, String autor, Long autorId) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.topico = topico;
        this.autor = autor;
        this.autorId = autorId;
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

    public topico getTopico() {
        return topico;
    }

    public void setTopico(topico topico) {
        this.topico = topico;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public List<comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
package com.example.foro.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comentario")
public class comentario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String mensaje;
    
    @ManyToOne
    @JoinColumn(name = "post_id")
    private publicaciones post;
    
    private String autor;
    private Long autorId;
    
    public comentario() {
    }
    
    public comentario(String mensaje, publicaciones post, String autor, Long autorId) {
        this.mensaje = mensaje;
        this.post = post;
        this.autor = autor;
        this.autorId = autorId;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public publicaciones getPost() {
        return post;
    }
    
    public void setPost(publicaciones post) {
        this.post = post;
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
}
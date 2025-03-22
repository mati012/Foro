package com.example.foro.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "topicos")
public class topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<publicaciones> posts;

    
    public topico() {
    }

    public topico(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<publicaciones> getPosts() {
        return posts;
    }

    public void setPosts(List<publicaciones> posts) {
        this.posts = posts;
    }
}
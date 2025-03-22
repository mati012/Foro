package com.example.foro.dto;

public class comentarioDto {
    private Long id;
    private String mensaje;
    private Long post_id;
    private Long autorId;
    
    public comentarioDto() {}
    
    public comentarioDto(Long id, String mensaje, Long post_id, Long autorId) {
        this.id = id;
        this.mensaje = mensaje;
        this.post_id = post_id;
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
    
    public Long getPost_id() { 
        return post_id; 
    }
    
    public void setPost_id(Long post_id) { 
        this.post_id = post_id; 
    }
    
    public Long getAutorId() { 
        return autorId; 
    }
    
    public void setAutorId(Long autorId) { 
        this.autorId = autorId; 
    }
}
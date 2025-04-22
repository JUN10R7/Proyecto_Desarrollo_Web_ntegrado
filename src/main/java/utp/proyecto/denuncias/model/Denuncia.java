package utp.proyecto.denuncias.model;

import java.time.LocalDateTime;

public class Denuncia {

    private Long id;
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private String categoria;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private String estado = "Registrada";
    private Long ciudadanoId;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCiudadano() {
        return ciudadanoId;
    }

    public void setCiudadano(Long ciudadanoId) {
        this.ciudadanoId = ciudadanoId;
    }

}

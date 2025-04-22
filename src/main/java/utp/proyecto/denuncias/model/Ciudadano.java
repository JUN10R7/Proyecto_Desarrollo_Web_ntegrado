package utp.proyecto.denuncias.model;

import java.util.List;

public class Ciudadano {

    private Long id;
    private String nombres;
    private String apellidos;
    private String dni;
    private String correo;
    private String telefono;

    private List<Denuncia> denuncias;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }

    public void nuevaDenuncia(Denuncia denuncia) {
        denuncias.add(denuncia);
    }

    public void eliminarDenuncia(Long denuncia) {
        denuncias.remove(denuncia);
    }

    public Denuncia buscarDenuncia(Long denuncia) {
        for (Denuncia d : denuncias) {
            if (d.getId() == denuncia) {
                return d;
            }
        }
        return null;
    }

    public Denuncia updateDenuncia(Denuncia denuncia) {
        for (Denuncia d : denuncias) {
            if (d.getId() == denuncia.getId()) {
                d = denuncia;
            }
        }
        return denuncia;
    }

}

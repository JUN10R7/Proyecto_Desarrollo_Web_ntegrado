package utp.proyecto.denuncias.service;

import org.springframework.stereotype.Service;
import utp.proyecto.denuncias.model.Ciudadano;
import utp.proyecto.denuncias.model.Denuncia;
import utp.proyecto.denuncias.repository.CiudadanoRepository;
import utp.proyecto.denuncias.repository.DenunciaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadanoService {

    private final CiudadanoRepository ciudadanoRepository;
    private final DenunciaRepository denunciaRepository;

    public CiudadanoService(CiudadanoRepository ciudadanoRepository, DenunciaRepository denunciaRepository) {
        this.ciudadanoRepository = ciudadanoRepository;
        this.denunciaRepository = denunciaRepository;
    }

    public Ciudadano registrarCiudadano(Ciudadano ciudadano) {
        ciudadanoRepository.guardar(ciudadano);
        return ciudadano;
    }

    public Denuncia registrar(Denuncia denuncia) {
        Ciudadano ciudadano = ciudadanoRepository.buscar(denuncia.getCiudadano());
        if (ciudadano == null) {
            throw new IllegalArgumentException("El ciudadano con ID " + denuncia.getCiudadano() + " no existe.");
        }
        return denunciaRepository.nuevaDenuncia(denuncia);
    }


    public List<Ciudadano> obtenerCiudadanos () {
        return ciudadanoRepository.listarCiudadanos();
    }

    public List<Denuncia> obtenerDenuncias () {
        return denunciaRepository.listarDenuncias();
    }

    public List<Denuncia> obtenerDenuncias(Long id) {
        return denunciaRepository.listarDenuncias()
                .stream()
                .filter(d -> id.equals(d.getCiudadano()))
                .toList();
    }

    public Denuncia obtenerDenuncia(Long denuncia) {
        return denunciaRepository.buscar(denuncia);
    }
    public Denuncia actualizarDenuncia (Denuncia denuncia) {
        return denunciaRepository.actualizarDenuncia(denuncia);
    }

    public void eliminarDenuncia(Long denuncia) {
        denunciaRepository.eliminarDenuncia(denuncia);
    }
}

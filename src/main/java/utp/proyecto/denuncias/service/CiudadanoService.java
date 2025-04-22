package utp.proyecto.denuncias.service;

import org.springframework.stereotype.Service;
import utp.proyecto.denuncias.model.Ciudadano;
import utp.proyecto.denuncias.model.Denuncia;
import utp.proyecto.denuncias.repository.CiudadanoRepository;
import utp.proyecto.denuncias.request.CiudadanoRequest;

import java.util.List;

@Service
public class CiudadanoService {

    private final CiudadanoRepository ciudadanoRepository;

    public CiudadanoService(CiudadanoRepository ciudadanoRepository) {
        this.ciudadanoRepository = ciudadanoRepository;
    }

    public Ciudadano registrarCiudadano(Ciudadano ciudadano) {
        ciudadanoRepository.guardar(ciudadano);
        return ciudadano;
    }

    public Denuncia registrar(Denuncia denuncia) {
        ciudadanoRepository.buscar(denuncia.getCiudadano()).nuevaDenuncia(denuncia);
        return denuncia;
    }

    public List<Denuncia> consulta (Long ciudadano) {
        return ciudadanoRepository.buscar(ciudadano).getDenuncias();
    }

    public List<Ciudadano> obtenerCiudadanos (Long id) {
        return ciudadanoRepository.listarCiudadanos();
    }

    public List<Denuncia> obtenerDenuncias(Long id) {
        return ciudadanoRepository.buscar(id).getDenuncias();
    }

    public Denuncia obtenerDenuncia(Long ciudadano, Long denuncia) {
        return ciudadanoRepository.buscar(ciudadano).buscarDenuncia(denuncia);

    }
    public Denuncia actualizarDenuncia (Denuncia denuncia) {
        return ciudadanoRepository.buscar(denuncia.getCiudadano()).updateDenuncia(denuncia);
    }

    public void eliminarDenuncia(Long ciudadano, Long denuncia) {
        ciudadanoRepository.buscar(ciudadano).eliminarDenuncia(denuncia);
    }
}

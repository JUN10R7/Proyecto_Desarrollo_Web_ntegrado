package utp.proyecto.denuncias.repository;

import org.springframework.stereotype.Repository;
import utp.proyecto.denuncias.model.Ciudadano;
import utp.proyecto.denuncias.service.CiudadanoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CiudadanoRepository {

    private final Map<Long, Ciudadano> ciudadanos = new HashMap<>();
    private AtomicLong secuencia = new AtomicLong(1);

    public Ciudadano guardar(Ciudadano c) {
        Long id = secuencia.getAndIncrement();
        c.setId(id);
        ciudadanos.put(id, c);
        return c;
    }

    public Ciudadano buscar(Long id) {
        return ciudadanos.get(id);
    }

    public List<Ciudadano> listarCiudadanos() {
        return new ArrayList<>(ciudadanos.values());
    }

}

package utp.proyecto.denuncias.repository;


import org.springframework.stereotype.Repository;
import utp.proyecto.denuncias.model.Ciudadano;
import utp.proyecto.denuncias.model.Denuncia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class DenunciaRepository {

    private final Map<Long, Denuncia> denuncias = new HashMap<>();
    private AtomicLong secuencia = new AtomicLong(1);

    public Denuncia nuevaDenuncia(Denuncia d) {
        Long id = secuencia.getAndIncrement();
        d.setId(id);
        denuncias.put(id, d);
        return d;
    }

    public Denuncia buscar(Long id) {
        return denuncias.get(id);
    }

    public List<Denuncia> listarDenuncias() {
        return new ArrayList<>(denuncias.values());
    }

    public Denuncia actualizarDenuncia(Denuncia d) {
        denuncias.put(d.getId(), d);
        return d;
    }

    public void eliminarDenuncia(Long denuncia) {
        denuncias.remove(denuncia);
    }
}

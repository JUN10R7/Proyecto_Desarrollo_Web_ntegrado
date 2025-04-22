package utp.proyecto.denuncias.controller;

import org.springframework.web.bind.annotation.*;
import utp.proyecto.denuncias.model.Ciudadano;
import utp.proyecto.denuncias.model.Denuncia;
import utp.proyecto.denuncias.request.CiudadanoRequest;
import utp.proyecto.denuncias.request.ObtenerDenunciaRequest;
import utp.proyecto.denuncias.service.CiudadanoService;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
public class CiudadanoController {

    private final CiudadanoService ciudadanoService;

    public CiudadanoController(CiudadanoService ciudadanoService) {
        this.ciudadanoService = ciudadanoService;
    }

    // POST - Crear nuevo usuario:
    @PostMapping("/usuario")
    public Ciudadano registrarUsuario(@RequestBody Ciudadano ciudadano) {
        return ciudadanoService.registrarCiudadano(ciudadano);
    }

    // POST - Crear una nueva denuncia:
    @PostMapping("/denuncia")
    public Denuncia registrarDenuncia(@RequestBody Denuncia denuncia) {
        return ciudadanoService.registrar(denuncia);
    }

    // GET - Obtener todas las denuncias:
    @GetMapping("/obtenerDenuncias")
    public List<Denuncia> obtenerDenuncias(@RequestBody CiudadanoRequest c) {
        return ciudadanoService.obtenerDenuncias(c.getId());
    }

    // GET - Obtener una denuncia por ID
    @GetMapping("/obtenerDenuncia")
    public Denuncia obtenerDenunciaPorId (@RequestBody ObtenerDenunciaRequest value){
        return ciudadanoService.obtenerDenuncia(value.getCiudadanoId(), value.getDenunciaId());
    }

    //PRUEBA
    // PUT - Actualizar completamente una denuncia existente
    @PutMapping()
    public Denuncia actualizarDenuncia (@RequestBody Denuncia denuncia){
        return ciudadanoService.actualizarDenuncia(denuncia);
    }

    // DELETE - Eliminar una denuncia por ID
    @DeleteMapping()
    public List<Denuncia> eliminarDenuncia (@RequestBody ObtenerDenunciaRequest eliminar){
        ciudadanoService.eliminarDenuncia(eliminar.getCiudadanoId(), eliminar.getDenunciaId());
        return ciudadanoService.obtenerDenuncias(eliminar.getCiudadanoId());
    }
}

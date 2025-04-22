package utp.proyecto.denuncias.controller;

import org.springframework.web.bind.annotation.*;
import utp.proyecto.denuncias.model.Ciudadano;
import utp.proyecto.denuncias.model.Denuncia;
import utp.proyecto.denuncias.request.IDRequest;
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

    // GET - Obtener usuarios:
    @GetMapping("/listarUsuarios")
    public List<Ciudadano> listarUsuarios() {
        return ciudadanoService.obtenerCiudadanos();
    }

    // GET - Obtener todas las denuncias:
    @GetMapping("/obtenerDenuncias")
    public List<Denuncia> obtenerDenuncias(@RequestParam Long id) {
        return ciudadanoService.obtenerDenuncias(id);
    }

    // GET - Obtener una denuncia por ID
    @GetMapping("/obtenerDenuncia")
    public Denuncia obtenerDenunciaPorId (@RequestParam Long id){
        return ciudadanoService.obtenerDenuncia(id);
    }

    //PRUEBA
    // PUT - Actualizar completamente una denuncia existente
    @PutMapping("/update")
    public Denuncia actualizarDenuncia (@RequestBody Denuncia denuncia){
        return ciudadanoService.actualizarDenuncia(denuncia);
    }

    // DELETE - Eliminar una denuncia por ID
    @DeleteMapping("/delete")
    public List<Denuncia> eliminarDenuncia (@RequestBody IDRequest eliminar){
        ciudadanoService.eliminarDenuncia(eliminar.getId());
        return ciudadanoService.obtenerDenuncias();
    }
}

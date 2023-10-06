package com.aeditip.controller;


import com.aeditip.model.Mascota;
import com.aeditip.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mascotas")
public class MascotaController {



    private MascotaService mascotaService;


    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @PostMapping
    public Mascota crearMascota(@RequestBody Mascota mascota){
        return mascotaService.crearMascota(mascota);
    }


    @GetMapping
    public List<Mascota> obtenerTodasLasMascotas(){
        return mascotaService.obtenerTodasMascotas();
    }

    @GetMapping("/{id}")
    public Mascota obtenerMascota(@PathVariable int id){
        return mascotaService.obtenerMascota(id);
    }


    @PutMapping("/{id}")
    public Mascota modificarMascota(@RequestBody Mascota mascota, @PathVariable int id){
        if(mascotaService.obtenerMascota(id) != null){
            return mascotaService.modificarMascota(mascota, id);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarMascota(@PathVariable int id){
        mascotaService.eliminarMascota(id);
    }


}

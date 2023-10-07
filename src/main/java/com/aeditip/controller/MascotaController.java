package com.aeditip.controller;


import com.aeditip.dto.MascotaDTO;
import com.aeditip.model.Mascota;
import com.aeditip.service.MascotaService;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("mascotas")
public class MascotaController {



    private MascotaService mascotaService;


    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @PostMapping
    public ResponseEntity<Mascota> crearMascota(@RequestBody MascotaDTO mascotaDTO){

        try{
            Mascota mascotaCreada = mascotaService.crearMascota(mascotaDTO);

            // Accede al ID de la mascota creada
            String idMascotaCreada = String.valueOf(mascotaCreada.getId());


            // Construye la URI utilizando el ID de la mascota creada
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/".concat(idMascotaCreada))
                    .buildAndExpand()
                    .toUri();
            // Retorna una respuesta con el código de estado 201 (CREATED) y la URI de la mascota creada en la cabecera "Location".
            return ResponseEntity.created(location).build();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Mascota>> obtenerTodasLasMascotas() {
        List<Mascota> mascotas = mascotaService.obtenerTodasMascotas();

        return ResponseEntity.ok(mascotas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> obtenerMascota(@PathVariable int id){
        Mascota mascota = mascotaService.obtenerMascota(id);

        if(mascota != null) return ResponseEntity.ok(mascota);
        else return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Mascota> modificarMascota(@RequestBody Mascota mascota, @PathVariable int id){
        if(mascotaService.obtenerMascota(id) != null){
            Mascota mascotaModificada = mascotaService.modificarMascota(mascota, id);
            return ResponseEntity.ok(mascotaModificada);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable int id){
        boolean eliminacionExitosa = mascotaService.eliminarMascota(id);

        if(eliminacionExitosa) return ResponseEntity.noContent().build(); // 204 No Content
        else return ResponseEntity.notFound().build(); // 404 Not Found
    }


}

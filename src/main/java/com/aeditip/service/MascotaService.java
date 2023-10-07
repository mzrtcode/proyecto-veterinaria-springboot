package com.aeditip.service;


import com.aeditip.dto.MascotaDTO;
import com.aeditip.model.Dueno;
import com.aeditip.model.Mascota;
import com.aeditip.model.Raza;
import com.aeditip.repository.IDuenoRepository;
import com.aeditip.repository.IMascotaRepository;
import com.aeditip.repository.IRazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {


    private IMascotaRepository mascotaRepo;
    private IDuenoRepository duenoRepository;
    private IRazaRepository razaRepository;


    public MascotaService(IMascotaRepository mascotaRepo,
                          IDuenoRepository duenoRepository,
                          IRazaRepository razaRepository
                          ) {
        this.mascotaRepo = mascotaRepo;
        this.duenoRepository = duenoRepository;
        this.razaRepository = razaRepository;
    }

    // Leer (R) SELECT * FROM mascota;
    public List<Mascota> obtenerTodasMascotas(){
        return mascotaRepo.findAll();
    }

    // Crear (C) INSERT INTO mascota VALUES (...)
    public Mascota crearMascota(MascotaDTO mascotaDTO){

        Mascota mascota = new Mascota();

        Dueno dueno = duenoRepository.findById(mascotaDTO.getIdDueno()).orElse(null);
        Raza raza = razaRepository.findById(mascotaDTO.getIdRaza()).orElse(null);

        mascota.setNombre(mascotaDTO.getNombre());
        mascota.setDueno(dueno);
        mascota.setRaza(raza);

        Mascota mascotaCreada = mascotaRepo.save(mascota);

        if(mascotaCreada != null) return mascotaCreada;
        else throw new RuntimeException("No se pudo crear la mascota");
    }

    // Leer (R) SELECT * FROM mascota WHERE id_mascota = '?';
    public Mascota obtenerMascota(int id){
        return mascotaRepo.findById(id).orElse(null);
    }

    // Modificar (U) UPDATE FROM mascota SET (...) WHERE id_estado = '?';
    public Mascota modificarMascota(Mascota mascota, int id){
        if(mascotaRepo.findById(id).isPresent()){
            return mascotaRepo.save(mascota);
        }
        return null;
    }

    // Eliminar fisicamente (D) DELETE FROM mascota WHERE id_mascota = '?';
    public boolean eliminarMascota(int id) {
        if (mascotaRepo.findById(id).isPresent()) {
            mascotaRepo.deleteById(id);
            return true; // Eliminación exitosa
        }
        return false; // La mascota no se encontró o no se pudo eliminar
    }



}

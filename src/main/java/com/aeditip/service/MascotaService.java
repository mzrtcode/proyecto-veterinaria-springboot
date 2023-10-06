package com.aeditip.service;


import com.aeditip.model.Mascota;
import com.aeditip.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {


    private IMascotaRepository mascotaRepo;


    public MascotaService(IMascotaRepository mascotaRepo) {
        this.mascotaRepo = mascotaRepo;
    }

    // Leer (R) SELECT * FROM mascota;
    public List<Mascota> obtenerTodasMascotas(){
        return mascotaRepo.findAll();
    }

    // Crear (C) INSERT INTO mascota VALUES (...)
    public Mascota crearMascota(Mascota mascota){
        return mascotaRepo.save(mascota);
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
    public void eliminarMascota(int id){
        if(mascotaRepo.findById(id).isPresent()){
            mascotaRepo.deleteById(id);
        }
    }



}

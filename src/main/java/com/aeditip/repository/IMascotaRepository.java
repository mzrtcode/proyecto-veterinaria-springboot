package com.aeditip.repository;

import com.aeditip.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMascotaRepository extends JpaRepository<Mascota, Integer > {

    //@Query
    //Con la anotacion @Query podemos colocar nuestras propias consultas
}

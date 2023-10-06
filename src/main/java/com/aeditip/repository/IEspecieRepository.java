package com.aeditip.repository;

import com.aeditip.model.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEspecieRepository extends JpaRepository<Especie, Integer> {
}

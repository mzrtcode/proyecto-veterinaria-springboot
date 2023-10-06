package com.aeditip.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mascota")
@Data
public class Mascota {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name = "id_raza")
    private Integer idRaza;

    @Column(name = "id_dueno")
    private Integer idDueno;

}

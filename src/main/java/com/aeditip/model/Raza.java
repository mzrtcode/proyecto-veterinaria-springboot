package com.aeditip.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "raza")
@Data
public class Raza {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_raza")
    private Integer idRaza;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_especie")
    private Especie especie;
}

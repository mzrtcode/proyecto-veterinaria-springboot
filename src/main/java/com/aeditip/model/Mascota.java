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


    @ManyToOne
    @JoinColumn(name = "id_raza")
    private Raza raza;


    @ManyToOne
    @JoinColumn(name = "id_dueno")
    private Dueno dueno;

}

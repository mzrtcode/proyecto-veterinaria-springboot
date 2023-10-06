package com.aeditip.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dueno")
@Data
public class Dueno {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dueno")
    private Integer idDueno;


    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;




}

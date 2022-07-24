package com.Carrera.crudCarrera.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="carrera")
public class parametros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="carrera")
    private String carrera;

    public parametros() {
    }

    public parametros(String carrera) {
        this.carrera = carrera;
    }
}

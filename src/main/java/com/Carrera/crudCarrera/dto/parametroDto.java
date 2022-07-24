package com.Carrera.crudCarrera.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class parametroDto {

    private Long id;
    private String carrera;

    public parametroDto() {
    }

    public parametroDto(String carrera) {
        this.carrera = carrera;
    }
}

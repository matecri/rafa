package com.Carrera.crudCarrera.controller;

import com.Carrera.crudCarrera.entity.parametros;
import com.Carrera.crudCarrera.services.parametrosService;
import com.Carrera.crudCarrera.dto.mensaje;
import com.Carrera.crudCarrera.dto.parametroDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("carreraPrueba")
public class controlador {

   @Autowired
    parametrosService parametrosServices;

    @GetMapping("/buscarPor/{id}")
    public  ResponseEntity<parametros> getOne(@PathVariable("id")Long id){
        if(!parametrosServices.existe(id)){
            return new ResponseEntity(new mensaje("El parametro no existe"),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(parametrosServices.buscarUno(id),HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody parametroDto parametroDto){
        parametros parametros =new parametros(parametroDto.getCarrera());
        parametrosServices.guardar(parametros);
        return new ResponseEntity(new mensaje("Usuario creado"),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody parametroDto parametroDTO, @PathVariable("id")Long id){
        LocalDate date= LocalDate.now();
        if (!parametrosServices.existe(id)){
            return new ResponseEntity<>(new mensaje("El parametro no existe"),HttpStatus.BAD_REQUEST);
        }
        parametros parametros= parametrosServices.buscarUno(id).get();
        parametros.setCarrera(parametroDTO.getCarrera());

        parametrosServices.guardar(parametros);
        return new ResponseEntity<>(new mensaje("parametro actualizado"),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> delete(@PathVariable("id")Long id){
        if (!parametrosServices.existe(id)){
            return new ResponseEntity<>(new mensaje("El parametro no existe"),HttpStatus.BAD_REQUEST);
        }
        parametrosServices.borrar(id);
        return new ResponseEntity(new mensaje("parametro eliminado"),HttpStatus.OK);
    }



}

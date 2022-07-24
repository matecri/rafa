package com.Carrera.crudCarrera.services;


import org.springframework.beans.factory.annotation.Autowired;
import com.Carrera.crudCarrera.repository.parametroReposority;
import com.Carrera.crudCarrera.entity.parametros;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class parametrosService {
    @Autowired
    parametroReposority parametroRepository;

    public void guardar(parametros parametross){
        parametroRepository.save(parametross);
    }
    public Optional<parametros> buscarUno(Long id){return parametroRepository.findById(id);}
    public boolean existe(Long id){return parametroRepository.existsById(id);}
    public void borrar(Long id){parametroRepository.deleteById(id);}


}

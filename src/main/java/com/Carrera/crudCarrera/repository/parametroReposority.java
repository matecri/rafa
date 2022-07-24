package com.Carrera.crudCarrera.repository;

import com.Carrera.crudCarrera.entity.parametros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface parametroReposority extends JpaRepository<parametros, Long> {

    boolean existsById(Long id);

}

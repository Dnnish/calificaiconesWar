package com.colegio.calificaciones.repository;


import com.colegio.calificaciones.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Alumnorepository extends JpaRepository<Alumno, Long> {

    //@Query("SELECT s FROM Alumno s WHERE s.name = ?1")
    Optional<Alumno> findByName(String nombre);

}

package com.colegio.calificaciones.repository;

import com.colegio.calificaciones.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long>{
    //@Query(value = "SELECT s FROM profesores s Where s.name = ?1",nativeQuery = true)
    Optional<Profesor> findByName(String nombre);


}


package com.colegio.calificaciones.repository;

import com.colegio.calificaciones.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    //@Query("SELECT s FROM asignaturas s Where s.name = ?1")
    Optional<Asignatura> findByName(String nombre);

}

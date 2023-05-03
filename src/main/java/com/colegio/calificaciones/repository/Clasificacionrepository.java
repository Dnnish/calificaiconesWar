package com.colegio.calificaciones.repository;

import com.colegio.calificaciones.model.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Clasificacionrepository extends JpaRepository<Clasificacion, Long>{

    Optional<Clasificacion> findById(long Id);

    List<Clasificacion> findByAlumnoId(long Id);

    List<Clasificacion> findByAsignaturaId(long id);


    //@Query("SELECT c FROM Clasificacion c LEFT JOIN FETCH c.alumno a LEFT JOIN FETCH c.asignatura WHERE a.id = :alumnoId")

    List<Clasificacion> findByAlumnoIdAndAsignaturaId(long alumnoId,long asignaturaId);

    List<Clasificacion> findByAsignaturaIdAndAlumnoId(long asignaturaId, long alumnoId);

    //Consigue todas las clasificaciones de la asignatura que esta relacionado con el profesor

    /**
     Busca todas las clasificaciones de una asignatura de un profesor dado.
     @param profesorId el ID del profesor cuyas clasificaciones se buscan
     @param asignaturaId el ID de la asignatura cuyas clasificaciones se buscan
     @return una lista de objeto {@link Clasificacion} que contiene las clasificaciones encontradas
     */
    @Query(value = "SELECT * FROM Clasificaciones cl\n" +
            "LEFT JOIN Asignaturas asig ON cl.cla_codasi = asig.asi_codasi\n" +
            "LEFT JOIN Profesores p ON p.pro_codpro = asig.asi_codpro\n" +
            "WHERE p.pro_codpro = :profesorId AND asig.asi_codasi = :asignaturaId", nativeQuery = true)
    List<Clasificacion> findByClasificacionByProfesorAndAsignatura(long profesorId, long asignaturaId);

    //conseguir todas las calificaciones de que estén relacinado con una asignatura

    @Query(value = "SELECT * FROM Clasificaciones cl\n" +
            "JOIN Asignaturas asig ON cl.cla_codasi = asig.asi_codasi\n" +
            "WHERE asig.asi_codasi = :asignaturaId", nativeQuery = true)
    List<Clasificacion> findByClasificacionesAndAsignatura(long asignaturaId);

    //conseguir todas las asignaturas relacionadas con el profesor
    @Query(value = "SELECT * FROM Asignaturas asig\n" +
            "JOIN Profesores p ON asig.asi_codpro = p.pro_codpro\n" +
            "WHERE p.pro_codpro = :profesorId",nativeQuery = true)
    List<Clasificacion> findByAsignaturaAndProfesor(long profesorId);
}
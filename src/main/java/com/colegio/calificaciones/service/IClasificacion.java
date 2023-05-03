package com.colegio.calificaciones.service;

import com.colegio.calificaciones.dto.ClasificacionDto;
import com.colegio.calificaciones.model.Clasificacion;

import java.util.List;

public interface IClasificacion {

    List<ClasificacionDto> getClasificacion();


    List<ClasificacionDto> getClasificacionesByAlumnoId(Long alumnoId);



    //Que un profesor pueda obtener de su asignatura/s las calificaciones por estudiante.
    List<ClasificacionDto> getClasificacionesByProfesorAndAsignatura(Long profesorId, Long asignaturaId);

    void addNewClasificacion(Clasificacion clasificacion);
}

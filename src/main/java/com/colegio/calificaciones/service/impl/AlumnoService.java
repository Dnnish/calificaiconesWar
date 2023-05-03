package com.colegio.calificaciones.service.impl;

import com.colegio.calificaciones.model.Alumno;
import com.colegio.calificaciones.repository.Alumnorepository;
import com.colegio.calificaciones.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlumnoService implements IAlumnoService {

    private final Alumnorepository alumnorepository;

    @Autowired
    public AlumnoService(Alumnorepository alumnorepository) {
        this.alumnorepository = alumnorepository;
    }

    public List<Alumno> getAlumnos(){
        return alumnorepository.findAll();
    }

    public void addNewAlumno(Alumno alumno){
        Optional<Alumno> alumnoOptional = alumnorepository.findByName(alumno.getName());
    }
}

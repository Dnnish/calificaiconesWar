package com.colegio.calificaciones.controller;

import com.colegio.calificaciones.model.Alumno;
import com.colegio.calificaciones.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/Profesor/{idProfesor}/asignatura/{nombreAsignatura}/Alumno")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    public AlumnoController() {
    }

    @GetMapping
    public List<Alumno> getAlumno(){
        return alumnoService.getAlumnos();
    }
}

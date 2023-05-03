package com.colegio.calificaciones.controller;

import com.colegio.calificaciones.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/Profesor")
public class ProfesorController {

    @Autowired
    private IProfesorService profesorService;

}

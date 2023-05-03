package com.colegio.calificaciones.service;

import com.colegio.calificaciones.model.Profesor;

import java.util.List;

public interface IProfesorService {


    List<Profesor> getProfesor();

    void addNewProfesor(Profesor profesor);
}

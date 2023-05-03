package com.colegio.calificaciones.service;

import com.colegio.calificaciones.model.Asignatura;

import java.util.List;

public interface IAsignaturaService {

    List<Asignatura> getAsignaturas();

    void addNewAsignatura(Asignatura asignatura);
}

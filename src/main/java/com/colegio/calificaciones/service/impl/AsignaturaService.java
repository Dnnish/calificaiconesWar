package com.colegio.calificaciones.service.impl;

import com.colegio.calificaciones.model.Asignatura;
import com.colegio.calificaciones.repository.AsignaturaRepository;
import com.colegio.calificaciones.service.IAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService implements IAsignaturaService {

    @Autowired
    private  AsignaturaRepository asignaturaRepository;


    @Override
    public List<Asignatura> getAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @Override
    public void addNewAsignatura(Asignatura asignatura){
        Optional<Asignatura> asignaturaOptional = asignaturaRepository.findByName(asignatura.getName());
    }
}

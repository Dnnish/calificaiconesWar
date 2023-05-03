package com.colegio.calificaciones.service.impl;

import com.colegio.calificaciones.model.Profesor;
import com.colegio.calificaciones.repository.ProfesorRepository;
import com.colegio.calificaciones.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService implements IProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> getProfesor(){
        return profesorRepository.findAll();
    }


    @Override
    public void addNewProfesor(Profesor profesor){
        Optional<Profesor> profesorOptional = profesorRepository.findByName(profesor.getPro_name());
    }
}

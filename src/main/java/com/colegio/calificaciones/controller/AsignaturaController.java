package com.colegio.calificaciones.controller;

import com.colegio.calificaciones.model.Asignatura;
import com.colegio.calificaciones.service.IAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Asignatura")
public class AsignaturaController {
    @Autowired
    private IAsignaturaService asignaturaService;


   @GetMapping
    public List<Asignatura> getAsignatura(){
       return asignaturaService.getAsignaturas();
   }

   @PostMapping
    public void registerNewAsignatura(@RequestBody Asignatura asignatura){
        asignaturaService.addNewAsignatura(asignatura);
   }

}

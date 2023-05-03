package com.colegio.calificaciones.config;

import com.colegio.calificaciones.model.Asignatura;
import com.colegio.calificaciones.repository.AsignaturaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AsignaturaConfig {

    @Bean("Asigna")
    CommandLineRunner commandLineRunner(AsignaturaRepository asignaturaRepository){

        return args -> {
            Asignatura Acceso = new Asignatura(
                    "Acceso a datos",
                    1L
            );
            Asignatura Sistemas = new Asignatura(
                    "Sistemas",
                    2L
            );
            Asignatura Programacion = new Asignatura(
                    "Programacion",
                    2L
            );
            asignaturaRepository.saveAll(
                    Arrays.asList(Acceso, Programacion,Sistemas)
            );
        };
    }
}

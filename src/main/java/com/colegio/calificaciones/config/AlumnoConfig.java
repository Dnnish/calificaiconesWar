package com.colegio.calificaciones.config;

import com.colegio.calificaciones.model.Alumno;
import com.colegio.calificaciones.repository.Alumnorepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class AlumnoConfig {
    @Bean("alumno")
    CommandLineRunner commandLineRunner(Alumnorepository repository) {
        return args -> {
            Alumno Dennis = new Alumno(

                    "Dennis"
            );
            Alumno Hector = new Alumno(
                    "Hector"
            );
            repository.saveAll(
                    Arrays.asList(Dennis, Hector)
            );
        };

    }
}

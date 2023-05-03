package com.colegio.calificaciones.config;

import com.colegio.calificaciones.model.Profesor;
import com.colegio.calificaciones.repository.ProfesorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ProfesorConfig {
    /**
     * @param profesorRepository
     * @return
     */
    @Bean("profe")
    CommandLineRunner commandLineRunner(ProfesorRepository profesorRepository) {
        return args -> {
            Profesor Qinxiu = new Profesor(
                    "Qinxiu"
            );

            Profesor Patxi = new Profesor(
                    "Patxi"
            );
            profesorRepository.saveAll(
                    Arrays.asList(Qinxiu,Patxi)
            );
        };

    }
}

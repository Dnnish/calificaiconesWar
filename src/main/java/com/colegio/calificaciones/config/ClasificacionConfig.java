package com.colegio.calificaciones.config;

import com.colegio.calificaciones.model.Clasificacion;
import com.colegio.calificaciones.repository.Clasificacionrepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ClasificacionConfig {

    @Bean("Clasificacion")
    CommandLineRunner commandLineRunner(Clasificacionrepository clasificacionrepository){

        return args -> {
            Clasificacion notasDennis = new Clasificacion(

                    10,
                    1L,
                    1L
            );
            Clasificacion notasDennis2 = new Clasificacion(
                    7,
                    3L,
                    1L
            );
            Clasificacion notasDennis3 = new Clasificacion(
              9,
              2L,
              1L
            );

            Clasificacion notasHector = new Clasificacion(
                    5,
                    1L,
                    2L
            );
            Clasificacion notasHector2 = new Clasificacion(
                    8,
                    2L,
                    2L
            );
            clasificacionrepository.saveAll(
                    Arrays.asList(notasDennis,notasHector,notasDennis2,notasHector2,notasDennis3)
            );
        };
    }
}

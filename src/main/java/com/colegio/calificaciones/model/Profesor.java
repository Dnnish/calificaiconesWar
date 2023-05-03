package com.colegio.calificaciones.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Profesores")
public class Profesor {
    @Id
    /*@SequenceGenerator(
            name = "Profesor_sequence",
            sequenceName = "Profesor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Profesor_sequence"
    )*/
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pro_codpro;
    @Column(name = "pro_name")
    private String name;


    //region constructores
    public Profesor() {
    }
    public Profesor(Long pro_codpro, String pro_name) {
        this.pro_codpro = pro_codpro;
        this.name = pro_name;
    }
    public Profesor(String pro_name) {
        this.name = pro_name;
    }
    //endregion

    //region getters y setters
    public Long getPro_codpro() {
        return pro_codpro;
    }

    public void setPro_codpro(Long pro_codpro) {
        this.pro_codpro = pro_codpro;
    }

    public String getPro_name() {
        return name;
    }

    public void setPro_name(String pro_name) {
        this.name = pro_name;
    }
    //endregion


}

package com.colegio.calificaciones.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Alumnos")
public class Alumno {
    @Id
    @SequenceGenerator(
            name = "Alumno_sequence",
            sequenceName = "Alumno_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Alumno_sequence"
    )
    private Long alu_codalu;
    @Column(name = "alu_name")
    private String name;


    //region contructores
    public Alumno() {
    }

    public Alumno(Long alu_codalu, String alu_name) {
        this.alu_codalu = alu_codalu;
        this.name = alu_name;
    }

    public Alumno(String alu_name) {
        this.name = alu_name;
    }
    //endregion
    //region getters y setters
    public Long getAlu_codalu() {
        return alu_codalu;
    }

    public void setAlu_codalu(Long alu_codalu) {
        this.alu_codalu = alu_codalu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
}

package com.colegio.calificaciones.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Clasificaciones")
public class Clasificacion {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "cla_notas")
    private Integer nota;
    @Column(name = "cla_codasi")
    private Long asignaturaId;
    @Column(name = "cla_codalu")
    private Long alumnoId;


    //region contructores
    public Clasificacion() {
    }
    public Clasificacion(Long id, int nota, Long asignaturaId, Long alumnoId) {
        this.id = id;
        this.nota = nota;
        this.asignaturaId = asignaturaId;
        this.alumnoId = alumnoId;
    }

    public Clasificacion(int nota, Long asignaturaId, Long alumnoId) {
        this.nota = nota;
        this.asignaturaId = asignaturaId;
        this.alumnoId = alumnoId;
    }

   //endregion

    //region getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }


    //endregion


}

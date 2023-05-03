package com.colegio.calificaciones.dto;

public class ProfesorDto {

    private int nota;
    private String asignaturaName;
    private String alumnoName;
    private String profesorName;

    //constructor
    public ProfesorDto() {
    }

    //region setters y getters
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getAsignaturaName() {
        return asignaturaName;
    }

    public void setAsignaturaName(String asignaturaName) {
        this.asignaturaName = asignaturaName;
    }

    public String getAlumnoName() {
        return alumnoName;
    }

    public void setAlumnoName(String alumnoName) {
        this.alumnoName = alumnoName;
    }

    public String getProfesorName() {
        return profesorName;
    }

    public void setProfesorName(String profesorName) {
        this.profesorName = profesorName;
    }

    //endregion
}

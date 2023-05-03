package com.colegio.calificaciones.dto;

public class ClasificacionDto {

    private Long id;
    private Long Asigid;
    private int nota;
    private String asignaturaName;
    private String alumnoName;

    private String urlImg = "http://localhost/imgweb/eva.jpg";

    //constructor
    public ClasificacionDto() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Long getAsigid() {
        return Asigid;
    }

    public void setAsigid(Long asignota) {
        Asigid = asignota;
    }
    //endregion
}
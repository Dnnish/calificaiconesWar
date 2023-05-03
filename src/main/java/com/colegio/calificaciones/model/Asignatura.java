package com.colegio.calificaciones.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long asi_codasi;
    @Column(name = "asi_name")
    private String name;
    @Column(name = "asi_codpro")
    private Long proid;

    //region Contructores
    public Asignatura() {
    }

    public Asignatura(Long asi_codasi, String asi_name, Long asi_codpro) {
        this.asi_codasi = asi_codasi;
        this.name = asi_name;
        this.proid = asi_codpro;
    }

    public Asignatura(String asi_name, Long asi_codpro) {
        this.name = asi_name;
        this.proid = asi_codpro;
    }
    //endregion
    //region getters y setters
    public Long getAsi_codasi() {
        return asi_codasi;
    }

    public void setAsi_codasi(Long asi_codasi) {
        this.asi_codasi = asi_codasi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getProid() {
        return proid;
    }

    public void setProid(Long proid) {
        this.proid = proid;
    }

    //endregion

}

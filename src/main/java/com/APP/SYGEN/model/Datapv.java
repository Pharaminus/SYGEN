package com.APP.SYGEN.model;

import java.time.LocalDate;

public class Datapv {
    private String ue;
    private String filiere;
    private String niveau;
    private String semestre;
    private String typePv;
    private LocalDate annee;
    public String getUe() {
        return ue;
    }
    public void setUe(String ue) {
        this.ue = ue;
    }
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    public String getNiveau() {
        return niveau;
    }
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    public String getTypePv() {
        return typePv;
    }
    public void setTypePv(String typePv) {
        this.typePv = typePv;
    }
    public LocalDate getAnnee() {
        return annee;
    }
    public void setAnnee(LocalDate annee) {
        this.annee = annee;
    }
    public Datapv() {
    }
    public Datapv(String ue, String filiere, String niveau, String semestre, String typePv, LocalDate annee) {
        this.ue = ue;
        this.filiere = filiere;
        this.niveau = niveau;
        this.semestre = semestre;
        this.typePv = typePv;
        this.annee = annee;
    }
    

    

}

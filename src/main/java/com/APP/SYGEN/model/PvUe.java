package com.APP.SYGEN.model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PvUe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPvUe;
    private int semestre;
    private LocalDate annee;
    @ManyToOne
    @JoinColumn(name = "idUE")
    private UE ue;
        
    public PvUe() {
    }
    public PvUe(int semestre, LocalDate annee, UE ue) {
        this.semestre = semestre;
        this.annee = annee;
        this.ue = ue;
    }
    public int getIdPvUe() {
        return idPvUe;
    }
    public void setIdPvUe(Integer idPvUe) {
        this.idPvUe = idPvUe;
    }
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    public LocalDate getAnnee() {
        return annee;
    }
    public void setAnnee(LocalDate annee) {
        this.annee = annee;
    }
    public UE getUe() {
        return ue;
    }
    public void setUe(UE ue) {
        this.ue = ue;
    }
    
}

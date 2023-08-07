package com.APP.SYGEN.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HistoriqueCorrection{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistCorrection;
    private String matricule;
    private float note;
    private String anonymat;
    private String nomEtudiant;
    private LocalDate dateModif;

    public HistoriqueCorrection() {
    }

    public HistoriqueCorrection(String matricule, float note, String anonymat, String nomEtudiant, LocalDate dateModif) {
        this.matricule = matricule;
        this.note = note;
        this.anonymat = anonymat;
        this.nomEtudiant = nomEtudiant;
        this.dateModif = dateModif;
    }
    
    public int getidHistCorrection() {
        return this.idHistCorrection;
    }

    public void setidHistCorrection(int idHistCorrection) {
        this.idHistCorrection = idHistCorrection;
    }

    public String getMatricule() {
        return this.matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public float getNote() {
        return this.note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getAnonymat() {
        return this.anonymat;
    }

    public void setAnonymat(String anonymat) {
        this.anonymat = anonymat;
    }

    public String getNomEtudiant() {
        return this.nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public LocalDate getDateModif() {
        return this.dateModif;
    }

    public void setDateModif(LocalDate dateModif) {
        this.dateModif = dateModif;
    }
    

}
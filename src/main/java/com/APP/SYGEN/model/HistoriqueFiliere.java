package com.APP.SYGEN.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class HistoriqueFiliere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistFil;

    @ManyToOne
    private Etudiant etudiant;

    // constructeur par defaut
    
    public HistoriqueFiliere() {
    }

    // constructeur paramettre
    public HistoriqueFiliere(Etudiant etudiant, String code) {
        this.etudiant = etudiant;
        this.code = code;
    }

    // getters et setters
    private String code;
    public int getIdHistFil() {
        return idHistFil;
    }
    public void setIdHistFil(int idHistFil) {
        this.idHistFil = idHistFil;
    }
    public Etudiant getEtudiant() {
        return etudiant;
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

}
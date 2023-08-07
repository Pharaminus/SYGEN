package com.APP.SYGEN.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class DetailPvUe {

    // attribut de la class
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private float note;
    @ManyToOne
    private PvUe pvUe;
    @ManyToOne
    private Etudiant etudiant;

    // constructeur parametre
    public DetailPvUe(float note, PvUe pvUe, Etudiant etudiant) {
        this.note = note;
        this.pvUe = pvUe;
        this.etudiant = etudiant;
    }
    // constructeur par defaut
    public DetailPvUe() {
    }

    // getters et setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getNote() {
        return note;
    }
    public void setNote(float note) {
        this.note = note;
    }
    public PvUe getPvUe() {
        return pvUe;
    }
    public void setPvUe(PvUe pvUe) {
        this.pvUe = pvUe;
    }
    public Etudiant getEtudiant() {
        return etudiant;
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }


}

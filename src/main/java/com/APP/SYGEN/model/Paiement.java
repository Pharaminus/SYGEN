package com.APP.SYGEN.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Paiement
 */

@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaie;
    private String nomBank;
    private String numRecu;
    private LocalDate datePaie;
    private float montant;

    @ManyToOne
    @JoinColumn(name = "idEtu")
    private Etudiant etudiant;
    


    public Paiement() {
    }
    

    public Paiement( String nomBank, String numRecu, LocalDate datePaie, float montant, Etudiant etudiant) {
        
        this.nomBank = nomBank;
        this.numRecu = numRecu;
        this.datePaie = datePaie;
        this.montant = montant;
        this.etudiant = etudiant;
    }


    public int getIdPaie() {
        return this.idPaie;
    }

    public void setIdPaie(int idPaie) {
        this.idPaie = idPaie;
    }

    public String getNomBank() {
        return this.nomBank;
    }

    public void setNomBank(String nomBank) {
        this.nomBank = nomBank;
    }

    public String getNumRecu() {
        return this.numRecu;
    }

    public void setNumRecu(String numRecu) {
        this.numRecu = numRecu;
    }

    public LocalDate getDatePaie() {
        return this.datePaie;
    }

    public void setDatePaie(LocalDate datePaie) {
        this.datePaie = datePaie;
    }

    public float getMontant() {
        return this.montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Etudiant getEtudiant() {
        return this.etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }



}
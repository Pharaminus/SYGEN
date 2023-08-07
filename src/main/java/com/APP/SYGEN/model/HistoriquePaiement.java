package com.APP.SYGEN.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HistoriquePaiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistPaie ;
    private float montant ;
    private String nomBank;
    private String numRecu;
    private LocalDate datePaie;
     

    @ManyToOne
    @JoinColumn(name = "idEtu")
    private Etudiant etudiant ;

    public HistoriquePaiement() {
    }


    public float getMontant() {
        return this.montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
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

    public Etudiant getEtudiant() {
        return this.etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }




}


package com.APP.SYGEN.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



/**
 * Participe
 */
@Entity
public class Participe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer Id;

    private String matricule ;
    private float note;
    private int anonymat;
    private String nomEtudiant;
    private LocalDate dateImportation;
    private int userId ;

    @ManyToOne
    @JoinColumn(name =  "idEval")
    private Evaluation evaluation ;

    @ManyToOne
    @JoinColumn(name = "idEtu")
    private Etudiant etudiant ;


    public Participe() {
    }
    

    public Participe(String matricule, float note, int anonymat, String nomEtudiant, LocalDate dateImportation, int userId, Evaluation evaluation, Etudiant etudiant) {
        this.matricule = matricule;
        this.note = note;
        this.anonymat = anonymat;
        this.nomEtudiant = nomEtudiant;
        this.dateImportation = dateImportation;
        this.userId = userId;
        this.evaluation = evaluation;
        this.etudiant = etudiant;
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

    public int getAnonymat() {
        return this.anonymat;
    }

    public void setAnonymat(int anonymat) {
        this.anonymat = anonymat;
    }

    public String getNomEtudiant() {
        return this.nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public LocalDate getDateImportation() {
        return this.dateImportation;
    }

    public void setDateImportation(LocalDate dateImportation) {
        this.dateImportation = dateImportation;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Evaluation getEvaluation() {
        return this.evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public Etudiant getEtudiant() {
        return this.etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    



   
    


}

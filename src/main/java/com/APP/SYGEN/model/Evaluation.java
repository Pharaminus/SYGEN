package com.APP.SYGEN.model;



import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Evaluation {
    // attribut d
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEval ;
    private LocalDate dateEval ;
    private float noteSur ; 
    private String typeEval ;
    private int semestre ;
    @ManyToOne
    @JoinColumn(name = "idUE")
    private UE ue;
   
    // @OneToMany(mappedBy = "evaluation")
    // private List<Etudiant> etudiant;
    @OneToMany(mappedBy = "evaluation")
    private List<Participe> participe;
    // constructeur par defaut

    public Evaluation() {
    }
   
    // constructeur parramettre

    public Evaluation( LocalDate dateEval, float note, String typeEval, int semestre, UE UE) {
      
        this.dateEval = dateEval;
        this.noteSur = note;
        this.typeEval = typeEval;
        this.semestre = semestre;
        this.ue = UE;
    }

    // getters et setters
    public int getIdEval() {
        return this.idEval;
    }

    public void setIdEval(Integer idEval) {
        this.idEval = idEval;
    }

    public LocalDate getDateEval() {
        return this.dateEval;
    }

    public void setDateEval(LocalDate dateEval) {
        this.dateEval = dateEval;
    }

    public float getNote() {
        return this.noteSur;
    }

    public void setNote(float note) {
        this.noteSur = note;
    }

    public String getTypeEval() {
        return this.typeEval;
    }

    public void setTypeEval(String typeEval) {
        this.typeEval = typeEval;
    }

    public int getSemestre() {
        return this.semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public UE getUE() {
        return this.ue;
    }

    public void setUE(UE UE) {
        this.ue = UE;
    }



    public List<Participe> getParticipe() {
        return participe;
    }

    public void setParticipe(List<Participe> participe) {
        this.participe = participe;
    }


}

package com.APP.SYGEN.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUE;
    private String codeUE;
    private String intutile;
    

    @OneToMany(mappedBy = "ue")
    private List<Evaluation> evaluation;

    @OneToMany(mappedBy = "ue")
    private List<PvUe> pvUes;

    public UE() {
    }

    public UE(String codeUE, String intutile) {

        this.codeUE = codeUE;
        this.intutile = intutile;
    }

    public int getIdUE() {
        return this.idUE;
    }

    public void setIdUE(Integer idUE) {
        this.idUE = idUE;
    }

    public String getCodeUE() {
        return this.codeUE;
    }

    public void setCodeUE(String codeUE) {
        this.codeUE = codeUE;
    }

    public String getIntutile() {
        return this.intutile;
    }

    public void setIntutile(String intutile) {
        this.intutile = intutile;
    }

    public List<Evaluation> getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(List<Evaluation> evaluation) {
        this.evaluation = evaluation;
    }

    public List<PvUe> getPvUes() {
        return pvUes;
    }

    public void setPvUes(List<PvUe> pvUes) {
        this.pvUes = pvUes;
    }

}

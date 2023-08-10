package com.APP.SYGEN.model;

public class statuAcademique {
    private Boolean etud;
    private Boolean inscription;
    private Boolean ccEval;
    private Boolean snEval;
    private Boolean tpEval;
    public statuAcademique() {
    }
    public statuAcademique(Boolean etud, Boolean inscription, Boolean ccEval, Boolean snEval, Boolean tpEval) {
        this.etud = etud;
        this.inscription = inscription;
        this.ccEval = ccEval;
        this.snEval = snEval;
        this.tpEval = tpEval;
    }
    public Boolean getEtud() {
        return etud;
    }
    public void setEtud(Boolean etud) {
        this.etud = etud;
    }
    public Boolean getInscription() {
        return inscription;
    }
    public void setInscription(Boolean inscription) {
        this.inscription = inscription;
    }
    public Boolean getCcEval() {
        return ccEval;
    }
    public void setCcEval(Boolean ccEval) {
        this.ccEval = ccEval;
    }
    public Boolean getSnEval() {
        return snEval;
    }
    public void setSnEval(Boolean snEval) {
        this.snEval = snEval;
    }
    public Boolean getTpEval() {
        return tpEval;
    }
    public void setTpEval(Boolean tpEval) {
        this.tpEval = tpEval;
    }
    
    
}

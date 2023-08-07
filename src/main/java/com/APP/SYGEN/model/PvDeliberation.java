package com.APP.SYGEN.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PvDeliberation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPvDelib;
    @ManyToOne
    private DetailPvUe detailPvUe;
    
    public PvDeliberation() {
    }
    
    public PvDeliberation(DetailPvUe detailPvUe, float oldNote) {
        this.detailPvUe = detailPvUe;
        this.oldNote = oldNote;
    }

    private float oldNote;
    public long getIdPvDelib() {
        return idPvDelib;
    }
    public void setIdPvDelib(Integer idPvDelib) {
        this.idPvDelib = idPvDelib;
    }
    public DetailPvUe getDetailPvUe() {
        return detailPvUe;
    }
    public void setDetailPvUe(DetailPvUe detailPvUe) {
        this.detailPvUe = detailPvUe;
    }
    public float getOldNote() {
        return oldNote;
    }
    public void setOldNote(float oldNote) {
        this.oldNote = oldNote;
    }


}


package com.APP.SYGEN.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
// @Table(name = "fil_niv")

public class FilNiv {
    // attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFil;
    private String Code;
    private String Libelle;

    @OneToMany(mappedBy = "filNiv")
    private List<Etudiant> etudiant;

    // constructeur par defaut
    public FilNiv() {
    }

    // constructeur paramettre
    public FilNiv(String Code, String Libelle) {

        this.Code = Code;
        this.Libelle = Libelle;
    }

    // getters et setters
    public int getId() {
        return this.idFil;
    }

    public void setId(Integer Id) {
        this.idFil = Id;
    }

    public String getCode() {
        return this.Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getLibelle() {
        return this.Libelle;
    }

    public void setLibelle(String Libelle) {
        this.Libelle = Libelle;
    }

    public List<Etudiant> getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(List<Etudiant> etudiant) {
        this.etudiant = etudiant;
    }

}

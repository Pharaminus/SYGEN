package com.APP.SYGEN.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Etudiant {
    // attribut de la class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtu;
    private String matricule;
    private String nom;
    @ManyToOne
    @JoinColumn(name = "idFil")
    private FilNiv filNiv;
    private int statutPaie;
    @OneToMany(mappedBy = "etudiant")
    private List<Participe> participe; 
    // constructeur par defaut
    public Etudiant() {
    }
    // constructeur paramettre
    public Etudiant(String matricule, String nom, FilNiv filNiv, int statutPaie) {
        this.matricule = matricule;
        this.nom = nom;
        this.filNiv = filNiv;
        this.statutPaie = statutPaie;
    }

    // getters et setters
    public long getIdEtu() {
        return this.idEtu;
    }
    public void setIdEtu(Integer idEtu) {
        this.idEtu = idEtu;
    }

    public String getMatricule() {
        return this.matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public FilNiv getFilNiv() {
        return this.filNiv;
    }

    public void setFilNiv(FilNiv filNiv) {
        this.filNiv = filNiv;
    }

    public int getStatutPaie() {
        return this.statutPaie;
    }

    public void setStatutPaie(int statutPaie) {
        this.statutPaie = statutPaie;
    }
    public List<Participe> getParticipe() {
        return participe;
    }
    public void setParticipe(List<Participe> participe) {
        this.participe = participe;
    }
    
}

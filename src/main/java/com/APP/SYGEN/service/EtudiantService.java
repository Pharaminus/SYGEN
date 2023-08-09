package com.APP.SYGEN.service;

import java.util.List;

import com.APP.SYGEN.model.Etudiant;

public interface EtudiantService {
    Etudiant CreateEtudiant(Etudiant etudiant);
    Etudiant UpdateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Etudiant etudiant);
    void deleteByIdEtudiant(Integer id);
    Etudiant getEtudiant(Integer id);
    List<Etudiant> getAllEtudiant();
    List<Etudiant> getEtudiantByFilNiv(String code);
    List<Etudiant> geEtudiantByMatricule(String matricule);
}
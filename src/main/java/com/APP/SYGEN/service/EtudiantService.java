package com.APP.SYGEN.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.type.descriptor.java.DateJavaType;
import org.hibernate.type.descriptor.java.LocalDateJavaType;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;

import com.APP.SYGEN.model.Etudiant;

public interface EtudiantService {
    Etudiant CreateEtudiant(Etudiant etudiant);
    Etudiant UpdateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Etudiant etudiant);
    void deleteByIdEtudiant(Integer id);
    Etudiant getEtudiant(Integer id);
    List<Etudiant> getAllEtudiant();
    List<Etudiant> getEtudiantByFilNiv(String filNiv);
    List<Etudiant> getEtudiantByMat(String matricule);
    List<Etudiant> getEtudiantByYears(int annee, String filNiv);
}
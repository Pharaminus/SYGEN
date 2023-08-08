package com.APP.SYGEN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APP.SYGEN.model.Etudiant;
import java.util.List;


public interface EtudiantRepository extends JpaRepository<Etudiant,Integer>{
    List<Etudiant> findByMatricule(String matricule);
    
}

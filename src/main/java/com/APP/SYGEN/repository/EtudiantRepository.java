package com.APP.SYGEN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APP.SYGEN.model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer>{
    
}

package com.APP.SYGEN.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.APP.SYGEN.model.Participe;

public interface ParticipeRepository extends JpaRepository<Participe, Integer> {
   List<Participe> findByMatricule(String matricule);
   List<Participe> findByNote(float note);
   List<Participe> findByDateImportation(LocalDate dateImportation);
}


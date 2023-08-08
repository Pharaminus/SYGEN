package com.APP.SYGEN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

import com.APP.SYGEN.model.Participe;
public interface ParticipeRepository extends JpaRepository<Participe, Integer> {
   List<Participe> findByMatricule(String matricule);
   List<Participe> findByDate_importation(int date_importation);
}

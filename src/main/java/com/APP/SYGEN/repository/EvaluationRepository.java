package com.APP.SYGEN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APP.SYGEN.model.Evaluation;
import java.util.List;


public interface EvaluationRepository extends JpaRepository<Evaluation,Integer>{
    List<Evaluation> findByTypeEval(String typeEval);
    
}

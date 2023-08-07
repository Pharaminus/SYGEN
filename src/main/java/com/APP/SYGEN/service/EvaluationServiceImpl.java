package com.APP.SYGEN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APP.SYGEN.model.Evaluation;
import com.APP.SYGEN.repository.EvaluationRepository;
@Service
public class EvaluationServiceImpl implements EvaluationService{
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Override
    public Evaluation CreateEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    @Override
    public Evaluation UpdateEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    @Override
    public void deleteEvaluation(Evaluation evaluation) {
        evaluationRepository.delete(evaluation);
    }

    @Override
    public void deleteByIdEvaluation(Integer id) {
        evaluationRepository.deleteById(id);
    }

    @Override
    public Evaluation getEvaluation(Integer id) {
        return evaluationRepository.findById(id).get();
    }

    @Override
    public List<Evaluation> getAllEvaluation() {
        return evaluationRepository.findAll();
    }
    
}

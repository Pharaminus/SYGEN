package com.APP.SYGEN.service;

import java.util.List;

import com.APP.SYGEN.model.Evaluation;

public interface EvaluationService {
    Evaluation CreateEvaluation(Evaluation Evaluation);
    Evaluation UpdateEvaluation(Evaluation Evaluation);
    void deleteEvaluation(Evaluation Evaluation);
    void deleteByIdEvaluation(Integer id);
    Evaluation getEvaluation(Integer id);
    List<Evaluation> getAllEvaluation();
}
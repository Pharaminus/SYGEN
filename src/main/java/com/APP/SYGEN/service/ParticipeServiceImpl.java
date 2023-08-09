package com.APP.SYGEN.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APP.SYGEN.model.Participe;
import com.APP.SYGEN.repository.ParticipeRepository;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.Query;

@Service
public class ParticipeServiceImpl implements ParticipeService {
    @Autowired
    private ParticipeRepository participeRepository;

    // private final EntityManager entityManager;

    // public ParticipeServiceImpl(EntityManager entityManager) {
    //     this.entityManager = entityManager;
    // }

    @Override
    public Participe CreateParticipe(Participe participe) {
        return participeRepository.save(participe);
    }

    @Override
    public Participe UpdateParticipe(Participe participe) {
        return participeRepository.save(participe);
    }

    @Override
    public void deleteParticipe(Participe participe) {
        participeRepository.delete(participe);
    }

    @Override
    public void deleteByIdParticipe(Integer id) {
        participeRepository.deleteById(id);
    }

    @Override
    public Participe getParticipe(Integer id) {
        return participeRepository.findById(id).get();
    }

    @Override
    public List<Participe> getAllParticipe() {
        return participeRepository.findAll();
    }

    // @Override
    // public List<Participe> getAllParticipeByYear(int annee) {
    //     return participeRepository.findByDate_importation(annee);
    // }

    @Override
    public List<Participe> getParticipeUe(String type, int semestre, LocalDate date, String codeUe) {
        List<Participe> participesDate = participeRepository.findByDateImportation(date);
        List<Participe> participesUe = new ArrayList<Participe>();

        for(int i = 0; i < participesDate.size(); i++){
            if(participesDate.get(i).getEvaluation().getTypeEval().equalsIgnoreCase(type) && participesDate.get(i).getEvaluation().getSemestre() == semestre && participesDate.get(i).getEvaluation().getUE().getCodeUE().equalsIgnoreCase(codeUe)){
                participesUe.add(participesDate.get(i));
            }
        }
        return participesUe;
    }

   





}

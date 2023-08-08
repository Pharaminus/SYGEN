package com.APP.SYGEN.service;

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

    @Override
    public Participe getAllParticipeByMat(String matricule, String type) {
        List<Participe> participes = new ArrayList<Participe>();
        participes = participeRepository.findByMatricule(matricule);
        Participe participesType = new Participe();
        for (int j = 0; j <participes.size(); j++) {
            if(participes.get(j).getEvaluation().getTypeEval().equalsIgnoreCase(type))
                participesType = participes.get(j);
        }
        return participesType;         
    }

    // @Override
    // public Participe getParticipeByMatAndNoteType(String matricule, String type) {
    //     List<Participe> participes = new ArrayList<Participe>();
    //     Participe participesType = new Participe();
    //     participes = participeRepository.findByMat(matricule);
    //     // Query query = (Query) entityManager.createQuery("SELECT * FROM participe WHERE participe.matricule = :matricule");
    //     // // jakarta.persistence.Query query2 = entityManager.createNativeQuery("SELECT * FROM participe WHERE participe.matricule = :matricule");
    //     // query.setParameter("matricule", matricule);
    //     // participes = query.getResultList();
    //     for (int j = 0; j <participes.size(); j++) {
    //         if(participes.get(j).getEvaluation().getTypeEval() == type)
    //             participesType = participes.get(j);
    //     }
    //     return participesType; 

    // }

}

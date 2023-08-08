package com.APP.SYGEN.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APP.SYGEN.model.Etudiant;
import com.APP.SYGEN.model.Participe;
import com.APP.SYGEN.repository.ParticipeRepository;
import com.APP.SYGEN.service.EtudiantService;
import com.APP.SYGEN.service.ParticipeService;





@RestController
@RequestMapping(path = "api")
public class TestControleur {

    @Autowired
    private ParticipeService participeService;

    @Autowired
    private ParticipeRepository participeRepository;
    @Autowired EtudiantService etudiantService;
    
    
    @GetMapping(path = "test")
    public String testShow(){
       Participe participe = new Participe();
        List<Participe> participes;
        List<Etudiant> etudiants = etudiantService.getAllEtudiant();

        List<Etudiant> etudiantFilNiv = new ArrayList<Etudiant>();
        etudiantFilNiv = etudiantService.getEtudiantByFilNiv("INF-L3") ;

        
    //    participe = participeService.getAllParticipeByMat("21T2668", "sn");
        // participes = participeRepository.findByMatricule("21t2660");
    //    return participe.getNomEtudiant();
    // return participes.get(1).getNomEtudiant();
    return etudiantFilNiv.get(3).getNom();
    }
    
    

   
    
}

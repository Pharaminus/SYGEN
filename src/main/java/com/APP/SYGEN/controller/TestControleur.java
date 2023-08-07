package com.APP.SYGEN.controller;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.APP.SYGEN.model.Participe;
import com.APP.SYGEN.service.ParticipeService;





@RestController
@RequestMapping(path = "api")
public class TestControleur {

    @Autowired
    private ParticipeService participeService;

    // @Autowired
    // private EtudiantService etudiantService;
    
    @GetMapping(path = "test")
    public String testShow(){
        Participe participe = new Participe();
        participe = participeService.getParticipe(1);
        // Etudiant etudiant = new Etudiant();
        // etudiant = etudiantService.getEtudiant(2);
       
        // return etudiant.getFilNiv().getCode();
        return participe.getEtudiant().getFilNiv().getLibelle();
    }
    
    

   
    
}

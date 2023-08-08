package com.APP.SYGEN.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APP.SYGEN.model.Etudiant;
import com.APP.SYGEN.repository.EtudiantRepository;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
@Service
public class EtudiantServiceImpl implements EtudiantService{
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public Etudiant CreateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant UpdateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Etudiant etudiant) {
        etudiantRepository.delete(etudiant);
    }

    @Override
    public void deleteByIdEtudiant(Integer id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiant(Integer id) {
        return etudiantRepository.findById(id).get();
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> getEtudiantByFilNiv(String filNiv) {
        List<Etudiant> etudiants = new ArrayList<Etudiant>();
        etudiants = etudiantRepository.findAll();
        List<Etudiant> etudiants2 = new ArrayList<Etudiant>();
        int j = 0;
        for(int i =0 ; i < etudiants.size(); i++){
            if(etudiants.get(i).getFilNiv().getCode().equalsIgnoreCase(filNiv))
            // j++;
                etudiants2.add(etudiants.get(i));
        }
        return etudiants2;
    }

    @Override
    public List<Etudiant> getEtudiantByYears(int annee) {
        List<Etudiant> etudiants;
    }

    @Override
    public List<Etudiant> getEtudiantByMat(String matricule) {
        return etudiantRepository.fin
    }
    
}

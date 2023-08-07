package com.APP.SYGEN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APP.SYGEN.model.Etudiant;
import com.APP.SYGEN.repository.EtudiantRepository;
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
    
}

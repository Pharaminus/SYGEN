package com.APP.SYGEN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APP.SYGEN.model.Participe;
import com.APP.SYGEN.repository.ParticipeRepository;
@Service
public class ParticipeServiceImpl implements ParticipeService{
    @Autowired
    private ParticipeRepository participeRepository;
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
    
}

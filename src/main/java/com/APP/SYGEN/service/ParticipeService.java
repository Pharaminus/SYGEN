package com.APP.SYGEN.service;

import java.util.List;

import com.APP.SYGEN.model.Participe;

public interface ParticipeService {
    Participe CreateParticipe(Participe participe);
    Participe UpdateParticipe(Participe participe);
    void deleteParticipe(Participe participe);
    void deleteByIdParticipe(Integer id);
    Participe getParticipe(Integer id);
    List<Participe> getAllParticipe();
}
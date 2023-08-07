package com.APP.SYGEN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APP.SYGEN.model.UE;
import com.APP.SYGEN.repository.UeRepository;
@Service
public class UeServiceImpl implements UeService{
    @Autowired
    private UeRepository ueRepository;
    @Override
    public UE CreateUE(UE ue) {
        return ueRepository.save(ue);
    }

    @Override
    public UE UpdateUE(UE ue) {
        return ueRepository.save(ue);
    }

    @Override
    public void deleteUE(UE ue) {
        ueRepository.delete(ue);
    }

    @Override
    public void deleteByIdUE(Integer id) {
        ueRepository.deleteById(id);
    }

    @Override
    public UE getUE(Integer id) {
        return ueRepository.findById(id).get();
    }

    @Override
    public List<UE> getAllUE() {
        return ueRepository.findAll();
    }
    
}

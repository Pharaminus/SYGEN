package com.APP.SYGEN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APP.SYGEN.model.PvUe;
import com.APP.SYGEN.repository.PvUeRepository;
@Service
public class PvUeServiceImpl implements PvUeService{
    @Autowired
    private PvUeRepository pvUeRepository;
    @Override
    public PvUe CreatePvUe(PvUe pvUe) {
        return pvUeRepository.save(pvUe);
    }

    @Override
    public PvUe UpdatePvUe(PvUe pvUe) {
        return pvUeRepository.save(pvUe);
    }

    @Override
    public void deletePvUe(PvUe pvUe) {
        pvUeRepository.delete(pvUe);
    }

    @Override
    public void deleteByIdPvUe(Integer id) {
        pvUeRepository.deleteById(id);
    }

    @Override
    public PvUe getPvUe(Integer id) {
        return pvUeRepository.findById(id).get();
    }

    @Override
    public List<PvUe> getAllPvUe() {
        return pvUeRepository.findAll();
    }
    
}

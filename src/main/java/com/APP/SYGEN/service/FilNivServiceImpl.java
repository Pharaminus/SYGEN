package com.APP.SYGEN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.APP.SYGEN.model.FilNiv;
import com.APP.SYGEN.repository.FilNivRepository;
@Service
public class FilNivServiceImpl implements FilNivService{
    @Autowired
    private FilNivRepository filNivRepository;
    @Override
    public FilNiv CreateFilNiv(FilNiv filNiv) {
        return filNivRepository.save(filNiv);
    }

    @Override
    public FilNiv UpdateFilNiv(FilNiv filNiv) {
        return filNivRepository.save(filNiv);
    }

    @Override
    public void deleteFilNiv(FilNiv filNiv) {
        filNivRepository.delete(filNiv);
    }

    @Override
    public void deleteByIdFilNiv(Integer id) {
        filNivRepository.deleteById(id);
    }

    @Override
    public FilNiv getFilNiv(Integer id) {
        return filNivRepository.findById(id).get();
    }

    @Override
    public List<FilNiv> getAllFilNiv() {
        return filNivRepository.findAll();
    }
    
}

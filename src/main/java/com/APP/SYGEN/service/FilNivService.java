package com.APP.SYGEN.service;

import java.util.List;

import com.APP.SYGEN.model.FilNiv;

public interface FilNivService {
    FilNiv CreateFilNiv(FilNiv filNiv);
    FilNiv UpdateFilNiv(FilNiv filNiv);
    void deleteFilNiv(FilNiv filNiv);
    void deleteByIdFilNiv(Integer id);
    FilNiv getFilNiv(Integer id);
    List<FilNiv> getAllFilNiv();
}
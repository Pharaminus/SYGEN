package com.APP.SYGEN.service;

import java.util.List;

import com.APP.SYGEN.model.PvUe;

public interface PvUeService {
    PvUe CreatePvUe(PvUe pvUe);
    PvUe UpdatePvUe(PvUe pvUevUe);
    void deletePvUe(PvUe pvUe);
    void deleteByIdPvUe(Integer id);
    PvUe getPvUe(Integer id);
    List<PvUe> getAllPvUe();
}
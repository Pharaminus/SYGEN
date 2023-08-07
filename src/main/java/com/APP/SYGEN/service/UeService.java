package com.APP.SYGEN.service;

import java.util.List;

import com.APP.SYGEN.model.UE;

public interface UeService {
    UE CreateUE(UE ue);
    UE UpdateUE(UE ue);
    void deleteUE(UE ue);
    void deleteByIdUE(Integer id);
    UE getUE(Integer id);
    List<UE> getAllUE();
}
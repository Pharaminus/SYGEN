package com.APP.SYGEN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APP.SYGEN.model.FilNiv;
import java.util.List;



public interface FilNivRepository extends JpaRepository<FilNiv,Integer>{
    FilNiv findByCode(String code);
}

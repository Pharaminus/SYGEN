package com.APP.SYGEN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.APP.SYGEN.model.UE;
import java.util.List;


public interface UeRepository extends JpaRepository<UE,Integer>{
    List<UE> findByCodeUE(String codeUE);
}

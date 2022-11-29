package com.curso.motoservice.service;

import com.curso.motoservice.entities.Moto;
import com.curso.motoservice.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {
    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> FindAllMotos(){
        return motoRepository.findAll();
    }
    public Moto findById(Long id) {
        return motoRepository.findById(id).orElse(null);
    }
    public List<Moto> findByUserId(Long userId) {
        return motoRepository.findByUserId(userId);
    }
    public Moto save(Moto moto){
        return motoRepository.save(moto);
    }
}

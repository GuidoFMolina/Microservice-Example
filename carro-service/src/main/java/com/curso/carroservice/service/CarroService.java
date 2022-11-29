package com.curso.carroservice.service;

import com.curso.carroservice.entities.Carro;
import com.curso.carroservice.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> findAll(){
        return carroRepository.findAll();
    }
    public Carro getCarById(Long id) {
        return carroRepository.findById(id).orElse(null);
    }
    public List<Carro> byUserId(Long userId){
        return carroRepository.findByUserId(userId);
    }
    public Carro save(Carro car){
        return carroRepository.save(car);
    }
}

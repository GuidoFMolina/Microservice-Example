package com.curso.carroservice.controller;

import com.curso.carroservice.entities.Carro;
import com.curso.carroservice.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> FindAllCarr(){
        List<Carro> cars = carroService.findAll();
        if(cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }
    @GetMapping("{id}")
    public ResponseEntity<Carro> CarFindById (@PathVariable(name="id") Long id){
        Carro car = carroService.getCarById(id);
        if(car == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Carro>> GetCarroById(@PathVariable(name="id") Long id){
        List<Carro> cars = carroService.byUserId(id);
        if(cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }
    @PostMapping
    public ResponseEntity<Carro> saveCar(@RequestBody Carro car){
        Carro carNew = carroService.save(car);
        return ResponseEntity.ok(carNew);
    }
}

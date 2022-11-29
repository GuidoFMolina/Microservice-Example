package com.curso.motoservice.controller;

import com.curso.motoservice.entities.Moto;
import com.curso.motoservice.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotoController {
    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> findAllMotos() {
        List<Moto> motos = motoService.FindAllMotos();
        if(motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Moto> findById(@PathVariable(name="id") Long id){
        Moto moto = motoService.findById(id);
        if(moto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<List<Moto>> findByUser(@PathVariable(name="id") Long userId){
        List<Moto> motos = motoService.findByUserId(userId);
        if (motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
    @PostMapping
    public ResponseEntity<Moto> saveMoto(@RequestBody Moto moto){
        Moto newMoto = motoService.save(moto);
        if ( newMoto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newMoto);
    }
}

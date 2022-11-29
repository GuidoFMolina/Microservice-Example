package com.curso.usuarioservice.controller;

import com.curso.usuarioservice.dto.UserDTO;
import com.curso.usuarioservice.entities.User;
import com.curso.usuarioservice.model.Carro;
import com.curso.usuarioservice.model.Moto;
import com.curso.usuarioservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAll();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable(name="id") Long id){
        User user = userService.getUserById(id);
        if(user == null){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    @GetMapping("carros/{userId}")
    public ResponseEntity<List<Carro>> getAllCarros(@PathVariable(name="userId") Long id){
        User user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        List<Carro> carros = userService.getCarros(id);
        return ResponseEntity.ok(carros);
    }
    @GetMapping("motos/{userId}")
    public ResponseEntity<List<Moto>> getAllMotos(@PathVariable(name="userId") Long id){
        User user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        List<Moto> motos = userService.getMotos(id);
        return ResponseEntity.ok(motos);
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user){
        UserDTO userNew = userService.saveUser(user);
        return ResponseEntity.ok(userNew);
    }
}

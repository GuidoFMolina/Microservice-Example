package com.curso.usuarioservice.service;

import com.curso.usuarioservice.dto.UserDTO;
import com.curso.usuarioservice.entities.User;
import com.curso.usuarioservice.mapper.UserMapper;
import com.curso.usuarioservice.model.Carro;
import com.curso.usuarioservice.model.Moto;
import com.curso.usuarioservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    UserMapper userMapper;

    public List<Carro> getCarros(Long userId) {
        List<Carro> carros = restTemplate.
                getForObject("http://localhost:8002/carros/user/" + userId, List.class );
        return carros;
    }
    public List<Moto> getMotos(Long userId) {
        List<Moto> motos = restTemplate.
                getForObject("http://localhost:8003/motos/user/" + userId, List.class );
        return motos;
    }
    public List<User> getAll(){
        return usuarioRepository.findAll();
    }
    public User getUserById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }
    public UserDTO saveUser(UserDTO userdto){
        User user = userMapper.carroDTOToCarro(userdto);
        User newUser = usuarioRepository.save(user);
        return userMapper.carroToCarroDTO(newUser);
    }

}

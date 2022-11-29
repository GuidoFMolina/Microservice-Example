package com.curso.usuarioservice.mapper;

import com.curso.usuarioservice.dto.CarroDTO;
import com.curso.usuarioservice.dto.UserDTO;
import com.curso.usuarioservice.entities.User;
import com.curso.usuarioservice.model.Carro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    ModelMapper modelMapper;

    public UserDTO carroToCarroDTO (User user) {
        return modelMapper.map(user, UserDTO.class);
    }
    public User carroDTOToCarro (UserDTO userdto) {
        return modelMapper.map(userdto, User.class);
    }

}

package br.com.fiap.cervejaria.services;

import br.com.fiap.cervejaria.CervejaDTO.CreateUserDTO;
import br.com.fiap.cervejaria.CervejaDTO.UserDTO;

public interface UserService {

    UserDTO create(CreateUserDTO createUserDTO);

}
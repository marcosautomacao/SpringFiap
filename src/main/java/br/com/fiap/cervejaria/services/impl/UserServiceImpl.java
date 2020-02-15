package br.com.fiap.cervejaria.services.impl;

import br.com.fiap.cervejaria.CervejaDTO.CreateUserDTO;
import br.com.fiap.cervejaria.CervejaDTO.UserDTO;
import br.com.fiap.cervejaria.Entity.User;
import br.com.fiap.cervejaria.repository.UserRepository;
import br.com.fiap.cervejaria.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO create(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setUsername(createUserDTO.getUsername());
        user.setPassword(createUserDTO.getPassword());

        User savedUser = userRepository.save(user);

        return new UserDTO(savedUser);
    }

}

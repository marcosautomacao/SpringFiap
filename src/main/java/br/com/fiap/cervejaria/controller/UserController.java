package br.com.fiap.cervejaria.controller;
import br.com.fiap.cervejaria.CervejaDTO.CreateUserDTO;
import br.com.fiap.cervejaria.CervejaDTO.UserDTO;
import br.com.fiap.cervejaria.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO create(@RequestBody CreateUserDTO createUserDTO) {
        return userService.create(createUserDTO);
    }
}

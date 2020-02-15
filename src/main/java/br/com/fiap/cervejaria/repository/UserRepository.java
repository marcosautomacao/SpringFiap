package br.com.fiap.cervejaria.repository;

import br.com.fiap.cervejaria.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findFirstByUsername(String username);

//    @("select u from User u where u.username = :username")
//    List<User> findByUsername(String username);
}

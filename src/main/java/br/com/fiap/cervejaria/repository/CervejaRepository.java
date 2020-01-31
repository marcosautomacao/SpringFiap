package br.com.fiap.cervejaria.repository;

import br.com.fiap.cervejaria.Entity.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Integer> {

}

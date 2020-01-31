package br.com.fiap.cervejaria.services;

import br.com.fiap.cervejaria.CervejaDTO.CervejaDTO;
import br.com.fiap.cervejaria.CervejaDTO.CreateCervejaDTO;
import br.com.fiap.cervejaria.CervejaDTO.Tipo;

import java.util.List;

public interface CervejaService {
    List<CervejaDTO> findAll(Tipo tipo);
    CervejaDTO findById(Integer id);
    CervejaDTO create(CreateCervejaDTO createCervejaDTO);
    CervejaDTO update(Integer id, CreateCervejaDTO createCervejaDTO);
    // CervejaDTO update(Integer id, CreateCervejaDTO createCervejaDTO );
    void delete(Integer id);
}

package br.com.fiap.cervejaria.services.impl;

import br.com.fiap.cervejaria.CervejaDTO.CervejaDTO;
import br.com.fiap.cervejaria.CervejaDTO.CreateCervejaDTO;
import br.com.fiap.cervejaria.CervejaDTO.Tipo;
import br.com.fiap.cervejaria.Entity.Cerveja;
import br.com.fiap.cervejaria.repository.CervejaRepository;
import br.com.fiap.cervejaria.services.CervejaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.fiap.cervejaria.CervejaDTO.Tipo.ALE;

@Service
public class CervejaServiceImpl implements CervejaService {


    private List<CervejaDTO> cervejaDTOList;
    private CervejaRepository cervejaRepository;

    public CervejaServiceImpl(CervejaRepository cervejaRepository) {
        this.cervejaRepository = cervejaRepository;
        cervejaDTOList = new ArrayList<>();

        cervejaDTOList.add(new CervejaDTO(
                1,
                "MARCA",
                3.5,
                ALE,
                BigDecimal.valueOf(17.9),
                ZonedDateTime.now().minusYears(1)
        ));

        cervejaDTOList.add(new CervejaDTO(
                2,
                "MARCA2",
                2.1,
                ALE,
                BigDecimal.valueOf(17.9),
                ZonedDateTime.now().minusYears(1)
        ));

        cervejaDTOList.add(new CervejaDTO(
                3,
                "MARCA3",
                1.3,
                ALE,
                BigDecimal.valueOf(17.9),
                ZonedDateTime.now().minusYears(1)
        ));
    }

    @Override
    public List<CervejaDTO> findAll(Tipo tipo) {
        return cervejaRepository.findAll()
                .stream()
                .map(CervejaDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CervejaDTO findById(Integer id) {
        return null;
    }

    @Override
    public CervejaDTO create(CreateCervejaDTO createCervejaDTO) {
        Cerveja cerveja = new Cerveja(createCervejaDTO);

        Cerveja savedCerveja = cervejaRepository.save(cerveja);

        return new CervejaDTO(savedCerveja);
    }

    @Override
    public CervejaDTO update(Integer id, CreateCervejaDTO createCervejaDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}

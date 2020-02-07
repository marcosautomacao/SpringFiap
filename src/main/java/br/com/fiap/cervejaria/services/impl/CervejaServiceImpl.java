package br.com.fiap.cervejaria.services.impl;

import br.com.fiap.cervejaria.CervejaDTO.CervejaDTO;
import br.com.fiap.cervejaria.CervejaDTO.CreateCervejaDTO;
import br.com.fiap.cervejaria.CervejaDTO.PrecoCervejaDto;
import br.com.fiap.cervejaria.CervejaDTO.Tipo;
import br.com.fiap.cervejaria.Entity.Cerveja;
import br.com.fiap.cervejaria.repository.CervejaRepository;
import br.com.fiap.cervejaria.services.CervejaService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    private Cerveja getCerveja(Integer id) {
        return cervejaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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

        Cerveja cerveja =  getCerveja(id);
        cerveja.setMarca(createCervejaDTO.getMarca());
        cerveja.setPreco(createCervejaDTO.getPreco());
        cerveja.setDataLancamento(createCervejaDTO.getDataLancamento());
        cerveja.setTipo(createCervejaDTO.getTipo());
        cerveja.setTeorAlcoolico(createCervejaDTO.getTeorAlcoolico());

        return saveAndGetCervejaDTO(cerveja);
    }

    private CervejaDTO saveAndGetCervejaDTO(Cerveja cerveja) {
        Cerveja savedCerveja = cervejaRepository.save(cerveja);
        return new CervejaDTO(savedCerveja);
    }

    @Override
    public CervejaDTO update(Integer id, PrecoCervejaDto precoCervejaDTO) {
        Cerveja cerveja = getCerveja(id);
        cerveja.setPreco(precoCervejaDTO.getPreco());

        return saveAndGetCervejaDTO(cerveja);
    }

    @Override
    public void delete(Integer id) {
        Cerveja cerveja = getCerveja(id);
        cervejaRepository.delete(cerveja);
    }
}

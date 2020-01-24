package br.com.fiap.cervejaria.controller;

import br.com.fiap.cervejaria.CervejaDTO.CervejaDTO;
import br.com.fiap.cervejaria.CervejaDTO.CreateCervejaDTO;
import br.com.fiap.cervejaria.CervejaDTO.Tipo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.fiap.cervejaria.CervejaDTO.Tipo.ALE;

@RestController
public class CervejaController {

    private List<CervejaDTO> cervejaDTOList;

    public CervejaController() {
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

    @GetMapping
    public List<CervejaDTO> getAll() {
        return cervejaDTOList;
    }

//    @GetMapping
//    public List<CervejaDTO> getByTipo(@RequestParam Tipo tipo) {
//        return cervejaDTOList.stream()
//                .filter(cervejaDTO -> cervejaDTO.getTipo().equals(tipo))
//                .collect(Collectors.toList());
//    }

    @GetMapping("{id}")
    public CervejaDTO findById(@PathVariable Integer id) {
        return cervejaDTOList.stream()
                .filter(cervejaDTO -> cervejaDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CervejaDTO create(@RequestBody @Valid CreateCervejaDTO createCervejaDTO) {
        CervejaDTO cervejaDTO = new CervejaDTO(createCervejaDTO, cervejaDTOList.size() + 1);
        cervejaDTOList.add(cervejaDTO);
        return cervejaDTO;
    }

    @PutMapping("{id}")
    public CervejaDTO update(@PathVariable Integer id, @RequestBody CreateCervejaDTO createCervejaDTO) {
        CervejaDTO cervejaDTO = findById(id);
        cervejaDTO.setMarca(createCervejaDTO.getMarca());
        cervejaDTO.setPreco(createCervejaDTO.getPreco());
        cervejaDTO.setTipo(createCervejaDTO.getTipo());
        cervejaDTO.setTeorAlcoolico(createCervejaDTO.getTeorAlcoolico());
        cervejaDTO.setDataLancamento(createCervejaDTO.getDataLancamento());

        return cervejaDTO;
    }

    @PatchMapping("{id}")
    public CervejaDTO updatePreco(@PathVariable Integer id, @RequestBody CreateCervejaDTO createCervejaDTO) {
        CervejaDTO cervejaDTO = findById(id);
        cervejaDTO.setPreco(createCervejaDTO.getPreco());

        return cervejaDTO;
    }

    @DeleteMapping("{id}")
    public CervejaDTO delete(@PathVariable Integer id, @RequestBody CreateCervejaDTO createCervejaDTO) {
        CervejaDTO cervejaDTO = findById(id);
        cervejaDTOList.remove(cervejaDTO);

        return cervejaDTO;
    }
}

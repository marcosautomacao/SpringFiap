package br.com.fiap.cervejaria.controller;

import br.com.fiap.cervejaria.CervejaDTO.CervejaDTO;
import br.com.fiap.cervejaria.CervejaDTO.CreateCervejaDTO;
import br.com.fiap.cervejaria.CervejaDTO.Tipo;
import br.com.fiap.cervejaria.services.CervejaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cerveja")
public class CervejaController {

    private final CervejaService service;

    public CervejaController(CervejaService service) {
        this.service = service;
    }

//    @GetMapping
//    public List<CervejaDTO> getAll() {
//        return service.findAll();
//    }

    @GetMapping
    public List<CervejaDTO> getByTipo(@RequestParam Tipo tipo) {
        return service.findAll(tipo);
    }

    @GetMapping("{id}")
    public CervejaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CervejaDTO create(@RequestBody @Valid CreateCervejaDTO createCervejaDTO) {
        return service.create(createCervejaDTO);
    }
//
//    @PutMapping("{id}")
//    public CervejaDTO update(@PathVariable Integer id, @RequestBody CreateCervejaDTO createCervejaDTO) {
//        CervejaDTO cervejaDTO = findById(id);
//        cervejaDTO.setMarca(createCervejaDTO.getMarca());
//        cervejaDTO.setPreco(createCervejaDTO.getPreco());
//        cervejaDTO.setTipo(createCervejaDTO.getTipo());
//        cervejaDTO.setTeorAlcoolico(createCervejaDTO.getTeorAlcoolico());
//        cervejaDTO.setDataLancamento(createCervejaDTO.getDataLancamento());
//
//        return cervejaDTO;
//    }
//
//    @PatchMapping("{id}")
//    public CervejaDTO updatePreco(@PathVariable Integer id, @RequestBody CreateCervejaDTO createCervejaDTO) {
//        CervejaDTO cervejaDTO = findById(id);
//        cervejaDTO.setPreco(createCervejaDTO.getPreco());
//
//        return cervejaDTO;
//    }

//    @DeleteMapping("{id}")
//    public CervejaDTO delete(@PathVariable Integer id, @RequestBody CreateCervejaDTO createCervejaDTO) {
//        CervejaDTO cervejaDTO = findById(id);
//        cervejaDTOList.remove(cervejaDTO);
//
//        return cervejaDTO;
//    }
}

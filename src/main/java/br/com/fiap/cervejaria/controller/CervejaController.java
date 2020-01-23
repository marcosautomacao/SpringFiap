package br.com.fiap.cervejaria.controller;

import br.com.fiap.cervejaria.CervejaDTO.CervejaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

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
    public List<CervejaDTO> GetAll() {
        return cervejaDTOList;
    }
}

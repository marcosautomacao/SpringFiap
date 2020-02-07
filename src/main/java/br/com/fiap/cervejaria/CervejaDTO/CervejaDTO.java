package br.com.fiap.cervejaria.CervejaDTO;

import br.com.fiap.cervejaria.Entity.Cerveja;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class CervejaDTO {
    private Integer Id;
    private String marca;
    private Double teorAlcoolico;
    private Tipo tipo;
    private BigDecimal preco;
    private ZonedDateTime dataLancamento;
    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataAtualizacao;

    public CervejaDTO(){}

    public CervejaDTO(Integer id, String marca, Double teorAlcoolico, Tipo tipo, BigDecimal preco, ZonedDateTime dataLancamento) {
        Id = id;
        this.marca = marca;
        this.teorAlcoolico = teorAlcoolico;
        this.tipo = tipo;
        this.preco = preco;
        this.dataLancamento = dataLancamento;
    }

    public CervejaDTO(CreateCervejaDTO createCervejaDTO, Integer id) {
        Id = id;
        this.marca = createCervejaDTO.getMarca();
        this.teorAlcoolico = createCervejaDTO.getTeorAlcoolico();
        this.tipo = createCervejaDTO.getTipo();
        this.preco = createCervejaDTO.getPreco();
        this.dataLancamento = createCervejaDTO.getDataLancamento();
    }

    public CervejaDTO(Cerveja cerveja) {
        Id = cerveja.getId();
        this.marca = cerveja.getMarca();
        this.teorAlcoolico = cerveja.getTeorAlcoolico();
        this.tipo = cerveja.getTipo();
        this.preco = cerveja.getPreco();
        this.dataLancamento = cerveja.getDataLancamento();
        this.dataCriacao = getZonedDateTime(cerveja);
        this.dataAtualizacao = getZonedDateTime(cerveja);
    }

    private ZonedDateTime getZonedDateTime(Cerveja cerveja) {
        return ZonedDateTime.ofInstant(
                cerveja.getDataCriacao().toInstant(),
                ZoneOffset.systemDefault()
        );
    }
    // shift f6 renomear

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(Double teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public ZonedDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(ZonedDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public ZonedDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(ZonedDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public ZonedDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(ZonedDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}

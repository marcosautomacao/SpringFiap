package br.com.fiap.cervejaria.CervejaDTO;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class CreateCervejaDTO {
        private String marca;
        private Double teorAlcoolico;
        private Tipo tipo;
        @Min(1)
        private BigDecimal preco;
        private ZonedDateTime dataLancamento;

        public CreateCervejaDTO(){}

        public CreateCervejaDTO(String marca, Double teorAlcoolico, Tipo tipo, BigDecimal preco, ZonedDateTime dataLancamento) {
            this.marca = marca;
            this.teorAlcoolico = teorAlcoolico;
            this.tipo = tipo;
            this.preco = preco;
            this.dataLancamento = dataLancamento;
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
    }

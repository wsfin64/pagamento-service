package com.example.pagamentoservice.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Pagamento {

    private static final long serialVerionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;
    private String codigo_fatura;
    private LocalDate dataPagamento;

    public Pagamento(){}

    public Pagamento(String codigo_fatura, LocalDate dataPagamento) {
        this.codigo_fatura = codigo_fatura;
        this.dataPagamento = dataPagamento;
    }

    public String getCodigo_fatura() {
        return codigo_fatura;
    }

    public void setCodigo_fatura(String codigo_fatura) {
        this.codigo_fatura = codigo_fatura;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}

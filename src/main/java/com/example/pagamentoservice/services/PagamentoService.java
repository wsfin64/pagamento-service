package com.example.pagamentoservice.services;

import com.example.pagamentoservice.entities.DTO.PagamentoDTO;
import com.example.pagamentoservice.entities.Pagamento;
import com.example.pagamentoservice.mensageria.QueueSender;
import com.example.pagamentoservice.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    QueueSender queueSender;

    public List<Pagamento> listarPagamentos(){
        return pagamentoRepository.findAll();
    }

    public Pagamento getPagamento(Long idPagamento){
        return pagamentoRepository.findById(idPagamento).get();
    }

    public Pagamento salvarPagamento(PagamentoDTO pagamentoDTO){
        String codigo_fatura = pagamentoDTO.getCodigo_fatura();

        queueSender.send(codigo_fatura);

        Pagamento pagamento = new Pagamento(codigo_fatura, LocalDate.now());

        return pagamentoRepository.save(pagamento);

    }

    public void deletarPagamento(Long idPagamento){
        pagamentoRepository.deleteById(idPagamento);
    }
}

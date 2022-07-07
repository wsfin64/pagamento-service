package com.example.pagamentoservice;

import com.example.pagamentoservice.entities.DTO.PagamentoDTO;
import com.example.pagamentoservice.entities.Pagamento;
import com.example.pagamentoservice.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/pagamentos")
public class Controller {

    @Autowired
    PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<Pagamento>> listarPagamentos(){
        return ResponseEntity.ok(pagamentoService.listarPagamentos());
    }

    @GetMapping("{idPagamento}")
    public ResponseEntity<Pagamento> buscarPagamento(@PathVariable Long idPagamento){
        return ResponseEntity.ok(pagamentoService.getPagamento(idPagamento));
    }

    @PostMapping
    public ResponseEntity<Pagamento> salvarPagamento(@RequestBody PagamentoDTO pagamentoDTO){
        return ResponseEntity.ok(pagamentoService.salvarPagamento(pagamentoDTO));
    }
}

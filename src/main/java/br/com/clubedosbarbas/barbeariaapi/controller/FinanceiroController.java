package br.com.clubedosbarbas.barbeariaapi.controller;

import br.com.clubedosbarbas.barbeariaapi.model.Financeiro;
import br.com.clubedosbarbas.barbeariaapi.service.FinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {

    @Autowired
    private FinanceiroService financeiroService;

    @GetMapping
    public ResponseEntity<List<Financeiro>> buscarTodosLancamentos() {
        List<Financeiro> lancamentos = financeiroService.buscarTodos();
        return ResponseEntity.ok(lancamentos);
    }

    @PostMapping
    public ResponseEntity<Financeiro> adicionarNovoLancamento(@RequestBody Financeiro lancamento) {
        Financeiro novoLancamento = financeiroService.adicionarLancamento(lancamento);
        return ResponseEntity.status(201).body(novoLancamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLancamento(@PathVariable("id") Long id) {
        financeiroService.deletarLancamento(id);
        return ResponseEntity.noContent().build();
    }

}
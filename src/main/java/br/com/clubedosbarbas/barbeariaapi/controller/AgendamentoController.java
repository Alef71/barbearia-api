package br.com.clubedosbarbas.barbeariaapi.controller;

import br.com.clubedosbarbas.barbeariaapi.model.Agendamento;
import br.com.clubedosbarbas.barbeariaapi.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.criarAgendamento(agendamento);
        return ResponseEntity.status(201).body(novoAgendamento);
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> buscarAgendaDoDia(
            @RequestParam Long barbeiroId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {

        List<Agendamento> agenda = agendamentoService.buscarAgendaDoDia(barbeiroId, data);
        return ResponseEntity.ok(agenda);
    }
}
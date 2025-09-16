package br.com.clubedosbarbas.barbeariaapi.controller;

import br.com.clubedosbarbas.barbeariaapi.model.Barbeiro;
import br.com.clubedosbarbas.barbeariaapi.service.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barbeiros")
public class BarbeiroController {

    @Autowired
    private BarbeiroService barbeiroService;

    @PostMapping
    public ResponseEntity<Barbeiro> criarBarbeiro(@RequestBody Barbeiro barbeiro) {
        Barbeiro novoBarbeiro = barbeiroService.salvar(barbeiro);
        return ResponseEntity.status(201).body(novoBarbeiro);
    }

    @GetMapping
    public ResponseEntity<List<Barbeiro>> listarBarbeiros() {
        List<Barbeiro> barbeiros = barbeiroService.buscarTodos();
        return ResponseEntity.ok(barbeiros);
    }
}
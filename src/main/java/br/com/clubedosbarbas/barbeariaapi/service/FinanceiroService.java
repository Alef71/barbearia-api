package br.com.clubedosbarbas.barbeariaapi.service;

import br.com.clubedosbarbas.barbeariaapi.model.Financeiro;
import br.com.clubedosbarbas.barbeariaapi.repository.FinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceiroService {

    @Autowired
    private FinanceiroRepository financeiroRepository;

    public List<Financeiro> buscarTodos() {
        return financeiroRepository.findAll();
    }

    public Financeiro adicionarLancamento(Financeiro lancamento) {
        return financeiroRepository.save(lancamento);
    }

    public void deletarLancamento(Long id) {
        if (!financeiroRepository.existsById(id)) {
            return;
        }
        financeiroRepository.deleteById(id);
    }

}
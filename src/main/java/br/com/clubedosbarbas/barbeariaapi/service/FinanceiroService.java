package br.com.clubedosbarbas.barbeariaapi.service;

import br.com.clubedosbarbas.barbeariaapi.model.Financeiro;
import br.com.clubedosbarbas.barbeariaapi.repository.FinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FinanceiroService {

    @Autowired
    private FinanceiroRepository financeiroRepository;

    public Financeiro adicionarLancamento(Financeiro lancamento) {
        return financeiroRepository.save(lancamento);
    }

    public List<Financeiro> listarLancamentosPorPeriodo(Long barbeiroId, LocalDate dataInicio, LocalDate dataFim) {
        return financeiroRepository.findByBarbeiroIdAndDataBetween(barbeiroId, dataInicio, dataFim);
    }

    public void deletarLancamento(Long id) {
        financeiroRepository.deleteById(id);
    }
}
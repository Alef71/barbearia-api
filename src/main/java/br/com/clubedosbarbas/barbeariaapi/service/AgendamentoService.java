package br.com.clubedosbarbas.barbeariaapi.service;

import br.com.clubedosbarbas.barbeariaapi.model.Agendamento;
import br.com.clubedosbarbas.barbeariaapi.model.Financeiro;
import br.com.clubedosbarbas.barbeariaapi.model.enums.TipoTransacao;
import br.com.clubedosbarbas.barbeariaapi.repository.AgendamentoRepository;
import br.com.clubedosbarbas.barbeariaapi.repository.FinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private FinanceiroRepository financeiroRepository;

    @Transactional
    public Agendamento criarAgendamento(Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoRepository.save(agendamento);

        Financeiro lancamentoFinanceiro = new Financeiro();
        lancamentoFinanceiro.setTipo(TipoTransacao.ENTRADA);
        lancamentoFinanceiro.setValor(novoAgendamento.getValor());
        lancamentoFinanceiro.setData(novoAgendamento.getDataHora().toLocalDate());
        lancamentoFinanceiro.setBarbeiro(novoAgendamento.getBarbeiro());

        String descricao = "Serviço: " + novoAgendamento.getTipoCorte() +
                " | Cliente: " + novoAgendamento.getCliente().getNome();
        lancamentoFinanceiro.setDescricao(descricao);

        financeiroRepository.save(lancamentoFinanceiro);

        return novoAgendamento;
    }

    public List<Agendamento> buscarAgendaDoDia(Long barbeiroId, LocalDate data) {
        LocalDateTime inicioDoDia = data.atStartOfDay();
        LocalDateTime fimDoDia = data.atTime(23, 59, 59);

        return agendamentoRepository.findByBarbeiroIdAndDataHoraBetween(barbeiroId, inicioDoDia, fimDoDia);
    }
}
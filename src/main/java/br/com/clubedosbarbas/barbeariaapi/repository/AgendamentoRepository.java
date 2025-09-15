package br.com.clubedosbarbas.barbeariaapi.repository;

import br.com.clubedosbarbas.barbeariaapi.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByBarbeiroIdAndDataHoraBetween(Long barbeiroId, LocalDateTime inicioDoDia,
            LocalDateTime fimDoDia);

}
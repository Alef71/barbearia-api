package br.com.clubedosbarbas.barbeariaapi.repository;

import br.com.clubedosbarbas.barbeariaapi.model.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {

    List<Financeiro> findByBarbeiroIdAndDataBetween(Long barbeiroId, LocalDate dataInicio, LocalDate dataFim);

}

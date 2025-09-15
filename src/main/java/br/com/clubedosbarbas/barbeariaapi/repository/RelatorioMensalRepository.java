package br.com.clubedosbarbas.barbeariaapi.repository;

import br.com.clubedosbarbas.barbeariaapi.model.RelatorioMensal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RelatorioMensalRepository extends JpaRepository<RelatorioMensal, Long> {

    Optional<RelatorioMensal> findByBarbeiroIdAndMesAndAno(Long barbeiroId, Integer mes, Integer ano);

}
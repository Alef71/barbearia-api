package br.com.clubedosbarbas.barbeariaapi.repository;

import br.com.clubedosbarbas.barbeariaapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
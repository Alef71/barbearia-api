package br.com.clubedosbarbas.barbeariaapi.repository;

import br.com.clubedosbarbas.barbeariaapi.model.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {

    UserDetails findByUsername(String username);

}
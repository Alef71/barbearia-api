package br.com.clubedosbarbas.barbeariaapi.service;

import br.com.clubedosbarbas.barbeariaapi.model.Barbeiro;
import br.com.clubedosbarbas.barbeariaapi.repository.BarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BarbeiroService {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    public Barbeiro salvar(Barbeiro barbeiro) {
        return barbeiroRepository.save(barbeiro);
    }

    public List<Barbeiro> buscarTodos() {
        return barbeiroRepository.findAll();
    }
}

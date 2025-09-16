package br.com.clubedosbarbas.barbeariaapi.service;

import br.com.clubedosbarbas.barbeariaapi.model.Cliente;
import br.com.clubedosbarbas.barbeariaapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
}

package br.com.clubedosbarbas.barbeariaapi.service;

import br.com.clubedosbarbas.barbeariaapi.model.Barbeiro;
import br.com.clubedosbarbas.barbeariaapi.repository.BarbeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BarbeiroService {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Barbeiro salvar(Barbeiro barbeiro) {
        String senhaPura = barbeiro.getSenha();

        String senhaCriptografada = passwordEncoder.encode(senhaPura);

        barbeiro.setSenha(senhaCriptografada);

        return barbeiroRepository.save(barbeiro);
    }

    public List<Barbeiro> buscarTodos() {
        return barbeiroRepository.findAll();
    }
}
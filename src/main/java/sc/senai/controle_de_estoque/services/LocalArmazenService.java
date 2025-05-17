package sc.senai.controle_de_estoque.services;


import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sc.senai.controle_de_estoque.entities.DTO.AlterarLocalArmazenDTO;

import sc.senai.controle_de_estoque.entities.LocalArmazen;
import sc.senai.controle_de_estoque.repositories.LocalArmazenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocalArmazenService {

    private LocalArmazenRepository localArmazenRepository;
    public LocalArmazenService(LocalArmazenRepository localArmazenRepository) {
        this.localArmazenRepository = localArmazenRepository;
    }


    //crud de localarmazen
    public LocalArmazen criarLocalArmazen(LocalArmazen localArmazen) {
        LocalArmazen local = new LocalArmazen();
        local.setSala(localArmazen.getSala());
        local.setArmario(localArmazen.getArmario());
        return localArmazenRepository.save(local);
    }

    public AlterarLocalArmazenDTO alterarLocalArmazen(AlterarLocalArmazenDTO localArmazenDTO, Long id) throws Exception {
        Optional<LocalArmazen> localArmazenBanco = localArmazenRepository.findById(id);
        if(localArmazenBanco.isEmpty()) {
            throw new Exception("local nao encontrado");
        }

            LocalArmazen local = localArmazenBanco.get();
            local.setSala(localArmazenDTO.getSala());
            local.setArmario(localArmazenDTO.getArmario());
            localArmazenRepository.save(local);
            return new AlterarLocalArmazenDTO();

    }

    public List<LocalArmazen> listarLocalArmazen() {
        return localArmazenRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<LocalArmazen> buscarLocalArmazenPorId(Long id) {
        return localArmazenRepository.findById(id);

    }

    public void excluirLocalArmazen(Long id) {
        localArmazenRepository.deleteById(id);

    }




}

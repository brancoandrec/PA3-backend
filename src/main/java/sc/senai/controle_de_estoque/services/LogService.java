package sc.senai.controle_de_estoque.services;

import org.springframework.stereotype.Service;
import sc.senai.controle_de_estoque.entities.Log;
import sc.senai.controle_de_estoque.repositories.LogRepository;

@Service
public class LogService {
    private final LogRepository logRepository;
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void salvarLog(String httpMetodo, String classe, String nomeMetodo) {
        Log log = new Log(httpMetodo, classe, nomeMetodo);
        logRepository.save(log);
    }

}

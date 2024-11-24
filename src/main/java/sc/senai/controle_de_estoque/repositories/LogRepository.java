package sc.senai.controle_de_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.senai.controle_de_estoque.entities.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
}

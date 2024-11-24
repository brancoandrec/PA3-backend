package sc.senai.controle_de_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.senai.controle_de_estoque.entities.ConjuntoItens;

public interface ConjuntoItensRepository extends JpaRepository<ConjuntoItens, Long> {
}

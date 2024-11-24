package sc.senai.controle_de_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.controle_de_estoque.entities.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}

package sc.senai.controle_de_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.controle_de_estoque.entities.ConjuntoItens;

import java.util.List;

@Repository
public interface ConjuntoItensRepository extends JpaRepository <ConjuntoItens, Long> {

    List<ConjuntoItens> findByProjetoNomeContainingIgnoreCase(String nome);
}

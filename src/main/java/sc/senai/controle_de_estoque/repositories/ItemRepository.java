package sc.senai.controle_de_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.controle_de_estoque.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    boolean existsByNome(String nome);
}

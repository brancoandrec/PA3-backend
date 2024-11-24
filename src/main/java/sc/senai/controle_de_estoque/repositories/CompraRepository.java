package sc.senai.controle_de_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.senai.controle_de_estoque.entities.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}

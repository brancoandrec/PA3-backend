package sc.senai.controle_de_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.controle_de_estoque.entities.Compra;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findByProjetoNomeContainingIgnoreCase(String nome);

    List<Compra> findByFornecedorNomeContainingIgnoreCase(String nome);

}

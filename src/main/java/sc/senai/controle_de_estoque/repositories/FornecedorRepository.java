package sc.senai.controle_de_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.controle_de_estoque.entities.Fornecedor;

import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    boolean existsByNome(String nome);
    Optional<Fornecedor> findByNome(String nome);

}

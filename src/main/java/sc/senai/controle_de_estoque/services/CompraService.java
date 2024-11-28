package sc.senai.controle_de_estoque.services;

import org.springframework.stereotype.Service;
import sc.senai.controle_de_estoque.entities.Compra;
import sc.senai.controle_de_estoque.entities.DTO.AlterarCompraDTO;
import sc.senai.controle_de_estoque.repositories.CompraRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    private CompraRepository compraRepository;
    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public Compra criarCompra(Compra compra) {
        Compra compr = new Compra();
        compr.setDataCompra(compra.getDataCompra());
        compr.setItem(compra.getItem());
        compr.setDataInvoice(compra.getDataInvoice());
        compr.setFornecedor(compra.getFornecedor());
        compr.setPreco(compra.getPreco());
        compr.setDataRecebimento(compra.getDataRecebimento());
        compr.setProjeto(compra.getProjeto());

        return compraRepository.save(compr);
    }

    public List<Compra> buscarTodas() {
        return compraRepository.findAll();
    }

    public Optional<Compra> buscarPorId(Long id) {
        return compraRepository.findById(id);
    }

    public void excluir(Long id) {
        compraRepository.deleteById(id);
    }

    public AlterarCompraDTO atualizarCompra(AlterarCompraDTO compraDTO) throws Exception {
        Optional<Compra> compra = compraRepository.findById(compraDTO.getId());

        if (Optional.ofNullable(compra).isPresent()) {
            compra.get().setDataCompra(compraDTO.getDataCompra());
            compra.get().setItem(compraDTO.getItem());
            compra.get().setDataInvoice(compraDTO.getDataInvoice());
            compra.get().setFornecedor(compraDTO.getFornecedor());
            compra.get().setPreco(compraDTO.getPreco());
            compra.get().setDataRecebimento(compraDTO.getDataRecebimento());
            compra.get().setProjeto(compraDTO.getProjeto());

            compraRepository.save(compra.get());
            return compraDTO;

        }
        throw new Exception("Compra não existe");
    }

    public List<Compra> buscarComprasPorNomeFornecedor(String nomeFornecedor) {
        return compraRepository.findByFornecedorNome(nomeFornecedor);
    }
}

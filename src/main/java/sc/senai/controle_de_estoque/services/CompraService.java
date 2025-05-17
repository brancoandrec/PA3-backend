package sc.senai.controle_de_estoque.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sc.senai.controle_de_estoque.entities.Compra;
import sc.senai.controle_de_estoque.entities.DTO.AlterarCompraDTO;
import sc.senai.controle_de_estoque.entities.DTO.CriarCompraDTO;
import sc.senai.controle_de_estoque.entities.Fornecedor;
import sc.senai.controle_de_estoque.entities.Item;
import sc.senai.controle_de_estoque.entities.Projeto;
import sc.senai.controle_de_estoque.repositories.CompraRepository;
import sc.senai.controle_de_estoque.repositories.FornecedorRepository;
import sc.senai.controle_de_estoque.repositories.ItemRepository;
import sc.senai.controle_de_estoque.repositories.ProjetoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    private final FornecedorRepository fornecedorRepository;
    private final ItemRepository itemRepository;
    private final ProjetoRepository projetoRepository;
    private CompraRepository compraRepository;
    public CompraService(CompraRepository compraRepository, FornecedorRepository fornecedorRepository, ItemRepository itemRepository, ProjetoRepository projetoRepository) {
        this.compraRepository = compraRepository;
        this.fornecedorRepository = fornecedorRepository;
        this.itemRepository = itemRepository;
        this.projetoRepository = projetoRepository;
    }

    public Compra criarCompra(CriarCompraDTO compra) {
        Compra compr = new Compra();
        Fornecedor fornecedor = fornecedorRepository.findByNome(compra.getFornecedorNome())
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado: " + compra.getFornecedorNome()));

        Projeto projeto = projetoRepository.findById(compra.getProjetoId())
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com ID: " + compra.getProjetoId()));

        List<Item> itens = itemRepository.findAllById(compra.getItemIds());

        compr.setFornecedor(fornecedor);
        compr.setItem(itens);
        compr.setProjeto(projeto);
        compr.setPreco(compra.getPreco());
        compr.setDataCompra(compra.getDataCompra());
        compr.setDataRecebimento(compra.getDataRecebimento());
        compr.setDataInvoice(compra.getDataInvoice());

        return compraRepository.save(compr);
    }

    public List<Compra> buscarTodas() {
        return compraRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
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
        return compraRepository.findByFornecedorNomeContainingIgnoreCase(nomeFornecedor);
    }
    public List<Compra> buscarPorNomeProjeto(String nomeProjeto){
        return compraRepository.findByProjetoNomeContainingIgnoreCase(nomeProjeto);
    }

    public List<Compra> findByProjetoId(Long idProjeto){
        return compraRepository.findByProjetoId(idProjeto);
    }
}

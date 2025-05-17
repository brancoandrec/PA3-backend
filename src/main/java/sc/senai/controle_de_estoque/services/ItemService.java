package sc.senai.controle_de_estoque.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sc.senai.controle_de_estoque.entities.DTO.CriarItemDTO;
import sc.senai.controle_de_estoque.entities.Item;
import sc.senai.controle_de_estoque.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item criarItem(CriarItemDTO criarItemDTO) throws Exception {
        Item item = new Item();
        item.setDescricao(criarItemDTO.getDescricao());
        item.setNome(criarItemDTO.getNome());
        item.setTipo(criarItemDTO.getTipo());

        return itemRepository.save(item);
    }

    public List<Item> listarItems() {
        return itemRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Item atualizarItem(Long id, Item item) throws Exception {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isEmpty()) {
            throw new Exception("Item não encontrado "+ id);
        }
        Item itemAtual = itemOptional.get();
        itemAtual.setDescricao(item.getDescricao());
        itemAtual.setNome(item.getNome());
        itemAtual.setTipo(item.getTipo());
        return itemRepository.save(itemAtual);

    }

    public void excluirItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Optional<Item> BuscarPorId(Long id) {
        return itemRepository.findById(id);
    }



}

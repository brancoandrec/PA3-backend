package sc.senai.controle_de_estoque.entities.DTO;

import sc.senai.controle_de_estoque.entities.Item;
import sc.senai.controle_de_estoque.entities.LocalArmazen;
import sc.senai.controle_de_estoque.entities.Projeto;

public class AlterarConjuntoItensDTO {
    private Long id;
    private int quantidade;
    private Item item;
    private LocalArmazen localArmazen;
    private Projeto projeto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalArmazen getLocalArmazen() {
        return localArmazen;
    }

    public void setLocalArmazen(LocalArmazen localArmazen) {
        this.localArmazen = localArmazen;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

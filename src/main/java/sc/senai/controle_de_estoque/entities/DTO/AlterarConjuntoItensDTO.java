package sc.senai.controle_de_estoque.entities.DTO;

import sc.senai.controle_de_estoque.entities.Item;
import sc.senai.controle_de_estoque.entities.LocalArmazen;
import sc.senai.controle_de_estoque.entities.Projeto;

public class AlterarConjuntoItensDTO {
    private Long id;
    private String descricao;
    private LocalArmazen localArmazen;
    private Projeto projeto;
    private Item item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

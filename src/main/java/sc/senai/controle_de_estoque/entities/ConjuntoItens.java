package sc.senai.controle_de_estoque.entities;

import jakarta.persistence.*;

@Entity
public class ConjuntoItens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    @ManyToOne
    private LocalArmazen localArmazen;
    @ManyToOne
    private Item item;
    @ManyToOne
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}

package sc.senai.controle_de_estoque.entities.DTO;

import sc.senai.controle_de_estoque.entities.Fornecedor;
import sc.senai.controle_de_estoque.entities.Item;
import sc.senai.controle_de_estoque.entities.Projeto;

import java.util.Date;
import java.util.List;

public class AlterarCompraDTO {
    private Long id;
    private List<Item> item;
    private Fornecedor fornecedor;
    private Projeto projeto;
    private Long preco;
    private Date dataCompra;
    private Date dataRecebimento;
    private Date dataInvoice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getDataInvoice() {
        return dataInvoice;
    }

    public void setDataInvoice(Date dataInvoice) {
        this.dataInvoice = dataInvoice;
    }
}

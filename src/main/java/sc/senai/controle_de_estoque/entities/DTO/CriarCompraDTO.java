package sc.senai.controle_de_estoque.entities.DTO;

import java.util.Date;
import java.util.List;

public class CriarCompraDTO {
        private List<Long> itemIds;
        private String fornecedorNome;
        private Long projetoId;
        private Long preco;
        private Date dataCompra;
        private Date dataRecebimento;
        private Date dataInvoice;

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public String getFornecedorNome() {
        return fornecedorNome;
    }

    public void setFornecedorNome(String fornecedorNome) {
        this.fornecedorNome = fornecedorNome;
    }

    public Long getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(Long projetoId) {
        this.projetoId = projetoId;
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

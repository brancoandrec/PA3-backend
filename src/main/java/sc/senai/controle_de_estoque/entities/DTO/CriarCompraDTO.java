package sc.senai.controle_de_estoque.entities.DTO;

import java.util.Date;
import java.util.List;

public class CriarCompraDTO {
        private List<String> itemNomes;
        private String fornecedorNome;
        private String projetoNome;
        private Long preco;
        private Date dataCompra;
        private Date dataRecebimento;
        private Date dataInvoice;


    public String getProjetoNome() {
        return projetoNome;
    }

    public void setProjetoNome(String projetoNome) {
        this.projetoNome = projetoNome;
    }

    public List<String> getItemNomes() {
        return itemNomes;
    }

    public void setItemNomes(List<String> itemNomes) {
        this.itemNomes = itemNomes;
    }

    public String getFornecedorNome() {
        return fornecedorNome;
    }

    public void setFornecedorNome(String fornecedorNome) {
        this.fornecedorNome = fornecedorNome;
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

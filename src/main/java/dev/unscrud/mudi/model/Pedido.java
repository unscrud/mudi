package dev.unscrud.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    private String nomeDoProduto;
    private BigDecimal valorNegociado;
    private LocalDate dataDaEntrega;
    private String urlProdudo;
    private String urlImagem;
    private String descricao;

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public BigDecimal getValorNegociado() {
        return valorNegociado;
    }

    public void setValorNegociado(BigDecimal valorNegociado) {
        this.valorNegociado = valorNegociado;
    }

    public LocalDate getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(LocalDate dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public String getUrlProdudo() {
        return urlProdudo;
    }

    public void setUrlProdudo(String urlProdudo) {
        this.urlProdudo = urlProdudo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}

package dev.unscrud.mudi.dto;

import dev.unscrud.mudi.model.Pedido;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoPedido {
    @NotBlank
    private String nomeProduto;
    
    @NotBlank
    private String urlProduto;
    
    @NotBlank
    private String urlImagem;
    
    private String descricao;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
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
    
    public Pedido toPedido(){
        Pedido pedido = new Pedido();
        pedido.setNomeDoProduto(nomeProduto);
        pedido.setDataDaEntrega(LocalDate.now());
        pedido.setDescricao(descricao);
        pedido.setUrlImagem(urlImagem);
        pedido.setUrlProduto(urlProduto);
        pedido.setValorNegociado(BigDecimal.ZERO);
        return pedido;
    }
                
}

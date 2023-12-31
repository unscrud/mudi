package dev.unscrud.mudi.dto;

import dev.unscrud.mudi.model.Oferta;
import dev.unscrud.mudi.model.Pedido;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequisicaoNovaOferta {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    private String pedidoUuid;
    
    @Pattern(regexp = "^\\d+(\\.\\d{2})?$")
    @NotEmpty
    private String valor;
    
    @Pattern(regexp = "^\\d{4}\\-\\d{2}\\-\\d{2}$")
    @NotEmpty
    private String dataDaEntrega;
    
    private String comentario;

    public String getPedidoUuid() {
        return pedidoUuid;
    }

    public void setPedidoUuid(String pedidoUuid) {
        this.pedidoUuid = pedidoUuid;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDataDaEntrega() {
        return dataDaEntrega;
    }

    public void setDataDaEntrega(String dataDaEntrega) {
        this.dataDaEntrega = dataDaEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Oferta toOferta(Pedido pedido) {
        Oferta oferta = new Oferta();
        oferta.setComentario(comentario);
        oferta.setDataDaEntrega(LocalDate.parse(dataDaEntrega,formatter));
        oferta.setValor(new BigDecimal(valor));
        oferta.setPedido(pedido);
        return oferta;
    }
}

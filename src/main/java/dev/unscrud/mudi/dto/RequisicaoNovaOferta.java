package dev.unscrud.mudi.dto;

public class RequisicaoNovaOferta {
    private String pedidoUuid;
    private String valor;
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
}

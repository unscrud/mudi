package dev.unscrud.mudi.record;

import dev.unscrud.mudi.model.StatusPedido;
import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoRecord (
    String uuid,
    String nomeDoProduto,
    BigDecimal valorNegociado,
    LocalDate dataDaEntrega,
    String urlProduto,
    String urlImagem,
    String descricao,
    StatusPedido statusPedido
) {}

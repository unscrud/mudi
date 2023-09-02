package dev.unscrud.mudi.api;

import dev.unscrud.mudi.model.Pedido;
import dev.unscrud.mudi.model.StatusPedido;
import dev.unscrud.mudi.record.PedidoRecord;
import dev.unscrud.mudi.repository.PedidoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping("aguardando")
    public List<PedidoRecord> getPedidoAguardandoOfertas() {
        Sort sort = Sort.by("uuid").descending();
        PageRequest paginacao = PageRequest.of(0, 5, sort);
        List<Pedido> pedidos = pedidoRepository.findByStatusPedido(StatusPedido.AGUARDANDO, paginacao);
        //TODO: Fazer de outra forma
        List<PedidoRecord> pedidosJson = new ArrayList<>();
        for (Pedido pedido: pedidos) {
            PedidoRecord pedidoRecord = new PedidoRecord(
                    pedido.getUuid(), 
                    pedido.getNomeDoProduto(), 
                    pedido.getValorNegociado(), 
                    pedido.getDataDaEntrega(), 
                    pedido.getUrlProduto(), 
                    pedido.getUrlImagem(), 
                    pedido.getDescricao(), 
                    pedido.getStatusPedido());
            pedidosJson.add(pedidoRecord);
        }
        return pedidosJson;
    }
}

package dev.unscrud.mudi.api;

import dev.unscrud.mudi.model.Oferta;
import dev.unscrud.mudi.dto.RequisicaoNovaOferta;
import dev.unscrud.mudi.model.Pedido;
import dev.unscrud.mudi.repository.PedidoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public Oferta criarOferta(RequisicaoNovaOferta requisicao) {
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoUuid());
        
        if(!pedidoBuscado.isPresent()){
            return null;
        }
        
        
        Pedido pedido = pedidoBuscado.get();
        Oferta nova = requisicao.toOferta(pedido);
        pedido.getOfertas().add(nova);
        
        pedidoRepository.save(pedido);
        
        return nova;
    }
}

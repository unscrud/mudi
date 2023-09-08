package dev.unscrud.mudi.api;

import dev.unscrud.mudi.model.Oferta;
import dev.unscrud.mudi.dto.RequisicaoNovaOferta;
import dev.unscrud.mudi.model.Pedido;
import dev.unscrud.mudi.repository.PedidoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @PostMapping
    public ResponseEntity<Oferta> criarOferta(@RequestBody RequisicaoNovaOferta requisicao) {
        try {
            Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoUuid());

            if(!pedidoBuscado.isPresent()){
                return null;
            }


            Pedido pedido = pedidoBuscado.get();
            Oferta nova = requisicao.toOferta(pedido);
            pedido.getOfertas().add(nova);

            pedidoRepository.save(pedido);

            return new ResponseEntity<>(nova, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

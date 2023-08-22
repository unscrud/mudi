package dev.unscrud.mudi.repository;

import dev.unscrud.mudi.model.Pedido;
import dev.unscrud.mudi.model.StatusPedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String>{

    public List<Pedido> findByStatusPedido(StatusPedido statusPedido);
}

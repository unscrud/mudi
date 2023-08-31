package dev.unscrud.mudi.repository;

import dev.unscrud.mudi.model.Pedido;
import dev.unscrud.mudi.model.StatusPedido;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String>{
    @Cacheable("pedidosPorStatus")
    public List<Pedido> findByStatusPedido(StatusPedido statusPedido, Pageable paginacao);

    @Query("SELECT p FROM Pedido p  JOIN p.user u WHERE u.username = :username AND p.statusPedido = :statusPedido")
    public List<Pedido> findByStatusPedidoAndUser( @Param("statusPedido") StatusPedido statusPedido, @Param("username") String username);

    @Query("SELECT p FROM Pedido p  JOIN p.user u WHERE u.username = :username")
    public List<Pedido> findAllByUser(@Param("username") String username);
}

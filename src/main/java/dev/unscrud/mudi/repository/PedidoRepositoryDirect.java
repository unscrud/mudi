package dev.unscrud.mudi.repository;

import dev.unscrud.mudi.model.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepositoryDirect {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Pedido> buscarTodosPedidos(){
        return (List<Pedido>) entityManager
                .createQuery("select p from Pedido p", Pedido.class)
                .getResultList();
    }
}

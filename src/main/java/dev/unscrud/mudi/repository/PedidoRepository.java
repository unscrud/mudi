package dev.unscrud.mudi.repository;

import dev.unscrud.mudi.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, String>{}


package org.springframework.samples.petclinic.repository;

import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

	@Query("SELECT producto FROM Producto producto WHERE producto.descuento <> 0 ORDER BY producto.descuento")
	Iterable<Producto> findProductosDescuento() throws DataAccessException;

	@Query("SELECT producto FROM Producto producto WHERE producto.id =:id")
	Optional<Producto> findById(@Param("id") int id);

	@Query("SELECT producto FROM Producto producto WHERE producto.actor.id =:id")
	Iterable<Producto> findByActorId(@Param("id") int id);

	@Query("SELECT producto FROM Producto producto WHERE producto.cantidad <> 0")
	Iterable<Producto> findTodosProductos();

}

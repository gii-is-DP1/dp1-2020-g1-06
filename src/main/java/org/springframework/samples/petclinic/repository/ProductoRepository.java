/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer>{

	@Query("SELECT producto FROM Producto producto WHERE producto.id =:id")
	Optional<Producto> findById(@Param("id") int id);

	@Query("SELECT producto FROM Producto producto WHERE producto.actor.id =:id")
	Collection<Producto> findByActorId(@Param("id") int id);
	
	@Query("SELECT producto FROM Producto producto WHERE producto.cantidad <> 0")
	Collection<Producto> findAllWithAmount();

	@Query("SELECT producto FROM Producto producto WHERE producto.nombre LIKE %:searchQuery%")
	Collection<Producto> findBySearchString(@Param("searchQuery") String searchQuery) throws DataAccessException;

	@Query("SELECT producto FROM Producto producto WHERE producto.descuento <> 0 ORDER BY producto.descuento")
	Collection<Producto> findWithDiscount() throws DataAccessException;
	
	@Query("DELETE FROM Producto producto WHERE producto.id =:id")
	Collection<Producto> delete(@Param("id") int id);
	
	
	Collection<Producto> findAll() throws DataAccessException;

	//void save(Producto producto) throws DataAccessException;

}

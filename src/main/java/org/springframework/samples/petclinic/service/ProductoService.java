/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Producto;
import org.springframework.samples.petclinic.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class ProductoService {

	private ProductoRepository productoRepository;


	@Autowired
	public ProductoService(final ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Transactional(readOnly = true)
	public Optional<Producto> findProductoById(final int id) throws DataAccessException {
		return this.productoRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public Iterable<Producto> findProductoByActorId(final int id) throws DataAccessException {
		return this.productoRepository.findByActorId(id);
	}

	@Transactional(readOnly = true)
	public Iterable<Producto> findProductosDescuento() throws DataAccessException {
		return this.productoRepository.findProductosDescuento();
	}
	@Transactional(readOnly = true)
	public Iterable<Producto> findTodosProductos() throws DataAccessException {
		return this.productoRepository.findTodosProductos();
	}

	@Transactional
	public void saveProducto(final Producto producto) throws DataAccessException {
		this.productoRepository.save(producto);
	}

}

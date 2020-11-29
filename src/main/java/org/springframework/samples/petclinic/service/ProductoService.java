/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
<<<<<<< HEAD
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Producto;
import org.springframework.samples.petclinic.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {

	private ProductoRepository productoRepository;

	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Transactional
	public Optional<Producto> findProductoById(int id) throws DataAccessException {
		return productoRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public Iterable<Producto> findProductoByActorId(final int id) throws DataAccessException {
		return this.productoRepository.findByActorId(id);
	}

	@Transactional
	public Collection<Producto> findAllWithAmount() throws DataAccessException {
		return productoRepository.findAllWithAmount();
	}

	@Transactional
	public Collection<Producto> findBySearchString(String searchQuery) throws DataAccessException {
		return productoRepository.findBySearchString(searchQuery);
	}

	@Transactional
	public Collection<Producto> findWithDiscount() throws DataAccessException {
		return productoRepository.findWithDiscount();
	}

	@Transactional
	public Collection<Producto> findAll() throws DataAccessException {
		return productoRepository.findAll();
	}
	
	@Transactional
	public void delete(Producto producto){
		productoRepository.delete(producto);
	}
	
	@Transactional
	public void saveProducto(final Producto producto) throws DataAccessException {
		this.productoRepository.save(producto);
	}
	

}

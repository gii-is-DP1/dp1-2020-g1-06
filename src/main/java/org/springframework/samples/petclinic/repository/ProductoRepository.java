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

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Producto;

public interface ProductoRepository extends Repository<Producto, Integer> {

	/**
	 * Retrieve a <code>Producto</code> from the data store by id.
	 * @param id the id to search for
	 * @return the <code>Producto</code> if found
	 * @throws org.springframework.dao.DataRetrievalFailureException if not found
	 */
	Producto findById(int id) throws DataAccessException;

	/**
	 * Save a <code>Producto</code> to the data store, either inserting or updating it.
	 * @param Producto the <code>Producto</code> to save
	 * @see BaseEntity#isNew
	 */
	void save(Producto producto) throws DataAccessException;

}

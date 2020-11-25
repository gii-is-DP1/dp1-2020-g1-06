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

package org.springframework.samples.petclinic.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Producto extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "actor_id")
	private Actor			actor;

	@Column(name = "nombre")
	@NotEmpty
	protected String		nombre;

	@Column(name = "descripcion")
	protected String		descripcion;

	@Column(name = "precio")
	@Min(0)
	@Digits(integer = 6, fraction = 2, message = "{javax.validation.constraints.Digits.message}")
	protected BigDecimal	precio;

	@Column(name = "cantidad")
	@Min(0)
	protected int			cantidad;

	@Column(name = "descuento")
	@Min(0)
	protected int			descuento;


	public Actor getActor() {
		return this.actor;
	}

	public void setActor(final Actor actor) {
		this.actor = actor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(final BigDecimal precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(final int cantidad) {
		this.cantidad = cantidad;
	}

	public int getDescuento() {
		return this.descuento;
	}

	public void setDescuento(final int descuento) {
		this.descuento = descuento;
	}

}

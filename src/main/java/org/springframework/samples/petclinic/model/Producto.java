package org.springframework.samples.petclinic.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "producto")
public class Producto extends BaseEntity{

	@Column(name = "nombre")
	@NotBlank
	protected String nombre;

	@Column(name = "descripcion")
	protected String descripcion;
	
	@Min(0)
	private Integer precio;

	@Min(0)
	private Integer cantidad;
	
	@Min(0)
	private Integer descuento;

	@ManyToOne
	@JoinColumn(name = "actor_id")
	private Actor actor;

}

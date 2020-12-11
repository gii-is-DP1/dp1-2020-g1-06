package org.springframework.samples.petclinic.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
//@MappedSuperclass
public class Actor extends BaseEntity {

	@NotBlank
	protected String nombre;

	@NotBlank
	@Email
	protected String email;

	@NotBlank
	protected String telefono;

	@NotBlank
	protected String direccion;

	@Min(0)
	protected int saldo;

	// @OneToOne(optional=false)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

}

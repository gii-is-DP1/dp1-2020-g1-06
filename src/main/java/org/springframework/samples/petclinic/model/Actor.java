
package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Actor extends BaseEntity {

	@Column(name = "nombre")
	@NotEmpty
	protected String nombre;
}

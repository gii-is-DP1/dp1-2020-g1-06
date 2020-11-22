package org.springframework.samples.petclinic.model;


import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Data
@Entity
@Table(name = "producto")
public class Producto extends BaseEntity{
	 @NotBlank
	 private String nombre;
	 
	 private String descripción;
	 @Min(0)
	 private Double precio;
	 @Min(0)
	 private Integer cantidad;
	 @Min(0) @Max(100)
	 private Integer descuento;
	
}

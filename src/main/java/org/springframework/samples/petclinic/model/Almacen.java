package org.springframework.samples.petclinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "Almacen")
public class Almacen extends BaseEntity{
    @NotBlank
    String nombre;
    @NotBlank
    String direccion;

    @Min(0)
    Integer cantidad_prod;

    @ManyToOne(optional = false)
    private Organizacion organizacion;


}

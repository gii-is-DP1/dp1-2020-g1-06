package org.springframework.samples.petclinic.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Almacen extends BaseEntity{
    @NotBlank
    String nombre;
    @NotBlank
    String direccion;

    @Min(0)
    Integer cantidad_prod;


}

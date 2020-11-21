package org.springframework.samples.petclinic.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Entity
@Table(name = "actor")
public class Actor extends BaseEntity{
    @NotBlank
    String nombre;
    @Email
    String email;
    @NotBlank
    Integer telefono;
    @NotBlank
    String direccion;
    @Min(0)
    Float saldo;

    Date fecha_nacimiento;

}

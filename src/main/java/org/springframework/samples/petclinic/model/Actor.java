package org.springframework.samples.petclinic.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
//@Entity
//@Table(name = "actor")
@MappedSuperclass
public abstract class Actor extends BaseEntity{
    @NotBlank
   private String nombre;
    @Email
  private  String email;
    @NotBlank
   private Integer telefono;
    @NotBlank
   private  String direccion;
    @Min(0)
   private Float saldo;

    @OneToOne(optional=false)
   private User usuario_cuenta;

   private Date fecha_nacimiento;


}

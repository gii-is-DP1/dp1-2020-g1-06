package org.springframework.samples.petclinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "usuario")
public class Usuario extends Actor {

}

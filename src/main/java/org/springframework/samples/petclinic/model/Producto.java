package org.springframework.samples.petclinic.model;


import lombok.Data;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;


@Data
@Entity
@Table(name = "producto")
public class Producto extends BaseEntity{
	 @NotBlank
	 private String nombre;
	 @Column(name = "descripción")
	 private String descripción;
	 @Min(0)
	 private Integer precio;
	 @Min(0)
	 private Integer cantidad;
	 @Min(0) @Max(100)
	 private Integer descuento;
    /*@ManyToMany(cascade =
        {CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    private Collection<Almacen> almacenes;*/
}

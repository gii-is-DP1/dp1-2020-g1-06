package org.springframework.samples.petclinic.repository;

import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.Almacen;
import org.springframework.samples.petclinic.model.Organizacion;

public interface AlmacenRepository extends Repository<Almacen,Integer> {
}

package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Moderador;

@org.springframework.stereotype.Repository
public interface ModeradorRepository extends JpaRepository<Moderador, Integer> {
    //ejemplo
    @Query("select m.id from Moderador m where m.nombre=:name")
    public Moderador findByName(@Param("name")String name);
}

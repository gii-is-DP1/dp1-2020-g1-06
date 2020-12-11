package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Organizacion;

@org.springframework.stereotype.Repository
public interface OrganizacionRepository extends Repository<Organizacion,Integer> {

	void save(Organizacion organizacion) throws DataAccessException;

    @Query("SELECT organizacion FROM Organizacion organizacion WHERE organizacion.id = :id")
    public Organizacion findById(@Param("id") int id) throws DataAccessException;

    @Query("SELECT organizacion FROM Organizacion organizacion WHERE organizacion.user.username = :username")
    public Organizacion findByUsername(@Param("username") String username) throws DataAccessException;

}

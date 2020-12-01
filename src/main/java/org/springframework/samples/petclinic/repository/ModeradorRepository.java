package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Moderador;

@org.springframework.stereotype.Repository
public interface ModeradorRepository extends Repository<Moderador,Integer> {

	void save(Moderador moderador) throws DataAccessException;

    @Query("SELECT moderador FROM Moderador moderador WHERE moderador.id = :id")
    public Moderador findById(@Param("id") int id) throws DataAccessException;

    @Query("SELECT moderador FROM Moderador moderador WHERE moderador.user.username = :username")
    public Moderador findByUsername(@Param("username") String username) throws DataAccessException;

}

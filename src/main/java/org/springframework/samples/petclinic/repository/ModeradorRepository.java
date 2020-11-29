package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Moderador;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface ModeradorRepository extends Repository<Moderador, Integer> {


    @Query("select m from Moderador m where m.nombre=:name")
    public Moderador findByName(@Param("name")String name);

    /**
     * Retrieve a <code>Moderador</code> from the data store by id.
     * @param id the id to search for
     * @return the <code>Moderador</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    @Query("SELECT moderador FROM Moderador moderador WHERE moderador.id =:id")
    public Moderador findById(@Param("id") int id)throws DataAccessException;


    /**
     * Retrieve <code>Moderador</code>s from the data store by last name, returning all owners
     * whose last name <i>starts</i> with the given name.
     * @param lastName Value to search for
     * @return a <code>Collection</code> of matching <code>Moderador</code>s (or an empty
     * <code>Collection</code> if none found)
     */
    @Query("SELECT DISTINCT moderador FROM Moderador moderador  WHERE moderador.apellidos LIKE :lastName%")
    public Collection<Moderador> findByLastName(@Param("lastName") String lastName);

    /**
     * Save an <code>Moderador</code> to the data store, either inserting or updating it.
     *
     * @param moderador the <code>Moderador</code> to save
     * @return
     * @see BaseEntity#isNew
     */
     void save(Moderador moderador) throws DataAccessException ;
}

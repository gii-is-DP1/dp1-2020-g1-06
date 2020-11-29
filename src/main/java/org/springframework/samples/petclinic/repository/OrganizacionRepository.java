package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Organizacion;



import java.util.Collection;

@org.springframework.stereotype.Repository
public interface OrganizacionRepository extends Repository<Organizacion,Integer> {
    /**
     * Save an <code>Organizacion</code> to the data store, either inserting or updating it.
     *
     * @param organizacion the <code>Organizacion</code> to save
     * @return
     * @see BaseEntity#isNew
     */
    void save(Organizacion organizacion) throws DataAccessException;

    /**
     * Retrieve <code>Organizacion</code>s from the data store by last name, returning all owners
     * whose last name <i>starts</i> with the given name.
     * @param lastName Value to search for
     * @return a <code>Collection</code> of matching <code>Organizacion</code>s (or an empty
     * <code>Collection</code> if none found)
     */
    @Query("SELECT DISTINCT organizacion FROM Organizacion organizacion  WHERE organizacion.apellidos LIKE :lastName%")
    public Collection<Organizacion> findByLastName(@Param("lastName") String lastName);

    /**
     * Retrieve a <code>Organizacion</code> from the data store by id.
     * @param id the id to search for
     * @return the <code>Organizacion</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    @Query("SELECT organizacion FROM Organizacion organizacion WHERE organizacion.id =:id")
    public Organizacion findById(@Param("id") int id)throws DataAccessException;
}

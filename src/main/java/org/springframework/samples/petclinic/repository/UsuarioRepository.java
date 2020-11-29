package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Moderador;
import org.springframework.samples.petclinic.model.UserAccount;
import org.springframework.samples.petclinic.model.Usuario;

import java.util.Collection;
@org.springframework.stereotype.Repository
public interface UsuarioRepository extends Repository<Usuario,Integer> {
    /**
     * Save an <code>Usuario</code> to the data store, either inserting or updating it.
     *
     * @param usuario the <code>Usuario</code> to save
     * @return
     * @see BaseEntity#isNew
     */
    void save(Usuario usuario) throws DataAccessException;

    /**
     * Retrieve <code>Usuario</code>s from the data store by last name, returning all owners
     * whose last name <i>starts</i> with the given name.
     * @param lastName Value to search for
     * @return a <code>Collection</code> of matching <code>Usuario</code>s (or an empty
     * <code>Collection</code> if none found)
     */
    @Query("SELECT DISTINCT usuario FROM Usuario usuario  WHERE usuario.apellidos LIKE :lastName%")
    public Collection<Usuario> findByLastName(@Param("lastName") String lastName);

    /**
     * Retrieve a <code>Usuario</code> from the data store by id.
     * @param id the id to search for
     * @return the <code>Usurio</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    @Query("SELECT usuario FROM Usuario usuario WHERE usuario.id =:id")
    public Usuario findById(@Param("id") int id)throws DataAccessException;
}

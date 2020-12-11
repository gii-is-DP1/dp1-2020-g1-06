package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Usuario;

@org.springframework.stereotype.Repository
public interface UsuarioRepository extends Repository<Usuario,Integer> {

	void save(Usuario usuario) throws DataAccessException;

    @Query("SELECT usuario FROM Usuario usuario WHERE usuario.id = :id")
    public Usuario findById(@Param("id") int id) throws DataAccessException;

    @Query("SELECT usuario FROM Usuario usuario WHERE usuario.user.username = :username")
    public Usuario findByUsername(@Param("username") String username) throws DataAccessException;

}

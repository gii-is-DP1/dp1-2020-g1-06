package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Usuario;
import org.springframework.samples.petclinic.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public Usuario getUsuarioByID(Integer id) {
        return usuarioRepository.findById(id);
    }


    @Transactional
    public Usuario setUsuarioName(Integer id, String new_name){
        Usuario usuario = usuarioRepository.findById(id);
        if(usuario != null){
            usuario.setNombre(new_name);
            usuarioRepository.save(usuario);
        }
        return usuario;
    }

    @Transactional(readOnly = true)
    public Collection<Usuario> findUsuarioByLastName(String lastName) throws DataAccessException {
        return usuarioRepository.findByLastName(lastName);
    }

    @Transactional
    public void saveUsuario(Usuario usuario) throws DataAccessException {
        //creating usuario
        usuarioRepository.save(usuario);
        //creating user
        userAccountService.saveUserAccount(usuario.getCuenta_actor());
    }
}

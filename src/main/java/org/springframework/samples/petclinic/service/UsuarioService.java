package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Usuario;
import org.springframework.samples.petclinic.repository.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    @Autowired
    private UserService userService;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public Usuario findById(int id) {
        return usuarioRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
    	return usuarioRepository.findByUsername(username);
    }

	/**
	 * Encuentra al usuario que está autenticado. Devuelve null si no hay
	 * nadie autenticado o si el usuario autenticado no es un usuario.
	 */
    @Transactional(readOnly = true)
    public Usuario findLoggedIn() {
    	Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if(loggedInUser instanceof org.springframework.security.core.userdetails.User) {
    		String username = ((org.springframework.security.core.userdetails.User) loggedInUser).getUsername();
    		return this.findByUsername(username);
    	} else {
    		return null;
    	}
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

    @Transactional
    public void saveUsuario(Usuario usuario) throws DataAccessException {
        //creating usuario
        usuarioRepository.save(usuario);
        //creating user
        userService.saveUser(usuario.getUser());
    }

}

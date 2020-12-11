package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Moderador;
import org.springframework.samples.petclinic.repository.ModeradorRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModeradorService {

    private ModeradorRepository moderadorRepository;
    @Autowired
    private UserService userService;

    @Autowired
    public ModeradorService(ModeradorRepository moderadorRepository) {
        this.moderadorRepository = moderadorRepository;
    }

    @Transactional(readOnly = true)
    public Moderador findById(int id) {
        return moderadorRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Moderador findByUsername(String username) {
    	return moderadorRepository.findByUsername(username);
    }

	/**
	 * Encuentra al moderador que está autenticado. Devuelve null si no hay
	 * nadie autenticado o si el usuario autenticado no es un moderador.
	 */
    @Transactional(readOnly = true)
    public Moderador findLoggedIn() {
    	Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if(loggedInUser instanceof org.springframework.security.core.userdetails.User) {
    		String username = ((org.springframework.security.core.userdetails.User) loggedInUser).getUsername();
    		return this.findByUsername(username);
    	} else {
    		return null;
    	}
    }

    @Transactional
    public Moderador setModeradorName(Integer id, String new_name){
        Moderador moderador = moderadorRepository.findById(id);
        if(moderador != null){
            moderador.setNombre(new_name);
            moderadorRepository.save(moderador);
        }
        return moderador;
    }

    @Transactional
    public void saveModerador(Moderador moderador) throws DataAccessException {
        //creating moderador
        moderadorRepository.save(moderador);
        //creating user
        userService.saveUser(moderador.getUser());
    }

}

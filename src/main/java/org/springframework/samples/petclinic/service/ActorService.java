package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Actor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActorService {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private OrganizacionService organizacionService;
	@Autowired
	private ModeradorService moderadorService;

	@Transactional(readOnly = true)
	public Actor findByUsername(String username) {
		Actor actor;
		actor = this.usuarioService.findByUsername(username);
		if(actor != null) {
			return actor;
		}
		actor = this.organizacionService.findByUsername(username);
		if(actor != null) {
			return actor;
		}
		actor = this.moderadorService.findByUsername(username);
		if(actor != null) {
			return actor;
		}
		return null;
	}

	/**
	 * Encuentra al actor que está autenticado. Devuelve null si no hay
	 * nadie autenticado o si el usuario autenticado no es un usuario.
	 */
	@Transactional(readOnly = true)
	public Actor findLoggedIn() {
		Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(loggedInUser instanceof org.springframework.security.core.userdetails.User) {
			String username = ((org.springframework.security.core.userdetails.User) loggedInUser).getUsername();
			return this.findByUsername(username);
		} else {
			return null;
		}
	}

}

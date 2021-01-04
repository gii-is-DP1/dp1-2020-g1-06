package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Actor;
import org.springframework.samples.petclinic.model.Moderador;
import org.springframework.samples.petclinic.model.Organizacion;
import org.springframework.samples.petclinic.model.Usuario;
import org.springframework.samples.petclinic.service.exceptions.SaldoException;
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
		if (actor != null) {
			return actor;
		}
		actor = this.organizacionService.findByUsername(username);
		if (actor != null) {
			return actor;
		}
		actor = this.moderadorService.findByUsername(username);
		if (actor != null) {
			return actor;
		}
		return null;
	}

	/**
	 * Encuentra al actor que está autenticado. Devuelve null si no hay nadie
	 * autenticado o si el usuario autenticado no es un usuario.
	 */
	@Transactional(readOnly = true)
	public Actor findLoggedIn() {
		Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (loggedInUser instanceof org.springframework.security.core.userdetails.User) {
			String username = ((org.springframework.security.core.userdetails.User) loggedInUser).getUsername();
			return this.findByUsername(username);
		} else {
			return null;
		}
	}

	@Transactional
	public Actor addToSaldo(String username, int creditos) throws SaldoException {
		Actor actor = this.findByUsername(username);
		// creditos no puede ser negativo
		if (creditos < 0) {
			throw new SaldoException();
		}
		if (actor != null) {
			if (actor instanceof Usuario) {
				Usuario usuario = (Usuario) actor;
				usuario.setSaldo(usuario.getSaldo() + creditos);
				// si ha habido overflow
				if (usuario.getSaldo() < 0) {
					throw new SaldoException();
				} else {
					this.usuarioService.saveUsuario(usuario);
				}
			}
			if (actor instanceof Organizacion) {
				Organizacion organizacion = (Organizacion) actor;
				organizacion.setSaldo(organizacion.getSaldo() + creditos);
				// si ha habido overflow
				if (organizacion.getSaldo() < 0) {
					throw new SaldoException();
				} else {
					this.organizacionService.saveOrganizacion(organizacion);
				}
			}
			if (actor instanceof Moderador) {
				Moderador moderador = (Moderador) actor;
				moderador.setSaldo(moderador.getSaldo() + creditos);
				// si ha habido overflow
				if (moderador.getSaldo() < 0) {
					throw new SaldoException();
				} else {
					this.moderadorService.saveModerador(moderador);
				}
			}
		}
		return actor;
	}

	@Transactional
	public Actor removeFromSaldo(String username, int creditos) throws SaldoException {
		Actor actor = this.findByUsername(username);
		// creditos no puede ser negativo
		if (creditos < 0) {
			throw new SaldoException();
		}
		if (actor != null) {
			if (actor instanceof Usuario) {
				Usuario usuario = (Usuario) actor;
				usuario.setSaldo(usuario.getSaldo() - creditos);
				// si se ha quitado más de lo que el actor tiene
				if (usuario.getSaldo() < 0) {
					throw new SaldoException();
				} else {
					this.usuarioService.saveUsuario(usuario);
				}
			}
			if (actor instanceof Organizacion) {
				Organizacion organizacion = (Organizacion) actor;
				organizacion.setSaldo(organizacion.getSaldo() - creditos);
				// si se ha quitado más de lo que el actor tiene
				if (organizacion.getSaldo() < 0) {
					throw new SaldoException();
				} else {
					this.organizacionService.saveOrganizacion(organizacion);
				}
			}
			if (actor instanceof Moderador) {
				Moderador moderador = (Moderador) actor;
				moderador.setSaldo(moderador.getSaldo() - creditos);
				// si se ha quitado más de lo que el actor tiene
				if (moderador.getSaldo() < 0) {
					throw new SaldoException();
				} else {
					this.moderadorService.saveModerador(moderador);
				}
			}
		}
		return actor;
	}

}

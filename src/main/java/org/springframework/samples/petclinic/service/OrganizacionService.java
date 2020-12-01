package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Organizacion;
import org.springframework.samples.petclinic.repository.OrganizacionRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrganizacionService {

	private OrganizacionRepository organizacionRepository;

	@Autowired
	private UserService userService;

	@Autowired
	public OrganizacionService(OrganizacionRepository organizacionRepository) {
		this.organizacionRepository = organizacionRepository;
	}

	@Transactional(readOnly = true)
	public Organizacion findById(int id) {
		return organizacionRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public Organizacion findByUsername(String username) {
		return organizacionRepository.findByUsername(username);
	}

	/**
	 * Encuentra a la organización que está autenticada. Devuelve null si no hay
	 * nadie autenticado o si el usuario autenticado no es una organización.
	 */
	@Transactional(readOnly = true)
	public Organizacion findLoggedIn() {
		Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (loggedInUser instanceof org.springframework.security.core.userdetails.User) {
			String username = ((org.springframework.security.core.userdetails.User) loggedInUser).getUsername();
			return this.findByUsername(username);
		} else {
			return null;
		}
	}

	@Transactional
	public Organizacion setOrganizacionName(Integer id, String new_name) {
		Organizacion organizacion = organizacionRepository.findById(id);
		if (organizacion != null) {
			organizacion.setNombre(new_name);
			organizacionRepository.save(organizacion);
		}
		return organizacion;
	}

	@Transactional
	public void saveOrganizacion(Organizacion organizacion) throws DataAccessException {
		// creating organizacion
		organizacionRepository.save(organizacion);
		// creating user
		userService.saveUser(organizacion.getUser());
	}

}

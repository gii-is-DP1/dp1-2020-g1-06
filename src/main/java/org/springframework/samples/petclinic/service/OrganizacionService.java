package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Organizacion;
import org.springframework.samples.petclinic.repository.OrganizacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class OrganizacionService {

    private OrganizacionRepository organizacionRepository;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    public OrganizacionService(OrganizacionRepository organizacionRepository) {
        this.organizacionRepository = organizacionRepository;
    }

    @Transactional(readOnly = true)
    public Organizacion getOrganizacionByID(Integer id) {
        return organizacionRepository.findById(id);
    }

    @Transactional
    public Organizacion setOrganizacionName(Integer id, String new_name){
        Organizacion organizacion = organizacionRepository.findById(id);
        if(organizacion != null){
            organizacion.setNombre(new_name);
            organizacionRepository.save(organizacion);
        }
        return organizacion;
    }

    @Transactional(readOnly = true)
    public Collection<Organizacion> findOrganizacionByLastName(String lastName) throws DataAccessException {
        return organizacionRepository.findByLastName(lastName);
    }
    @Transactional
    public void saveOrganizacion(Organizacion organizacion) throws DataAccessException {
        //creating organizacion
        organizacionRepository.save(organizacion);
        //creating user
        userAccountService.saveUserAccount(organizacion.getCuenta_actor());
    }
}

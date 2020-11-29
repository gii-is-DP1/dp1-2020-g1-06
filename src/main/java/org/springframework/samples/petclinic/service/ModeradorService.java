package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Moderador;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.ModeradorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;


@Service
public class ModeradorService {


    private ModeradorRepository moderadorRepository;
    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    public ModeradorService(ModeradorRepository moderadorRepository) {
        this.moderadorRepository = moderadorRepository;
    }

    @Transactional(readOnly = true)
    public Moderador getMoedradorByID(Integer id) {
        return moderadorRepository.findById(id);
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

    @Transactional(readOnly = true)
    public Collection<Moderador> findModeradorByLastName(String lastName) throws DataAccessException {
        return moderadorRepository.findByLastName(lastName);
    }

    @Transactional
    public void saveModerador(Moderador moderador) throws DataAccessException {
        //creating moderador
        moderadorRepository.save(moderador);
        //creating user
        userAccountService.saveUserAccount(moderador.getCuenta_actor());
    }
}

package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Moderador;
import org.springframework.samples.petclinic.repository.ModeradorRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ModeradorService {


    private ModeradorRepository moderadorRepository;

    @Autowired
    public ModeradorService(ModeradorRepository moderadorRepository) {
        this.moderadorRepository = moderadorRepository;
    }

    public Integer getMoedradorID(Integer id) {
        return moderadorRepository.findById(id).get().getId();
    }

    public Moderador setModeradorName(Integer id, String new_name){
        Moderador moderador = moderadorRepository.findById(id).get();
        if(moderador != null){
            moderador.setNombre(new_name);
            moderadorRepository.save(moderador);
        }
        return moderador;
    }
}

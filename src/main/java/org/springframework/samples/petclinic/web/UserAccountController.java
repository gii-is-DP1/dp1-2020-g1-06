package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Moderador;
import org.springframework.samples.petclinic.model.Usuario;
import org.springframework.samples.petclinic.service.ModeradorService;
import org.springframework.samples.petclinic.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserAccountController {

    private static final String VIEWS_MODERADOR_CREATE_FORM = "users/registerModeradorForm";


    private final  ModeradorService moderadorService;



    @Autowired
    public UserAccountController(ModeradorService moderadorService) {
        this.moderadorService = moderadorService;

    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping(value = "/users/new_moderador")
    public String initCreationForm(Map<String, Object> model) {
        Moderador moderador = new Moderador();
        model.put("moderador", moderador);
        return VIEWS_MODERADOR_CREATE_FORM;
    }

    @PostMapping(value = "/users/new_moderador")
    public String processCreationForm(@Valid Moderador moderador, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_MODERADOR_CREATE_FORM;
        }
        else {
            //creating moderador, user,
            this.moderadorService.saveModerador(moderador);
            return "redirect:/";
        }
    }



}


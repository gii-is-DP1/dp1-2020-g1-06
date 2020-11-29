package org.springframework.samples.petclinic.web;

import org.springframework.samples.petclinic.model.Moderador;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class ModeradorController {

  /*  private static final String VIEWS_MODERADOR_CREATE_FORM = "users/registerModeradorForm";

   // private final OwnerService ownerService;

    public void JSGetSelectedItem(Object objet){
        System.out.println(objet);
    }

    @GetMapping(value = "/moderador/new")
    public String initCreationForm(Map<String, Object> model) {
        Moderador owner = new Moderador();
        model.put("moderador", owner);
        return VIEWS_MODERADOR_CREATE_FORM;
    }

    @PostMapping(value = "/moderador/new")
    public String processCreationForm(Moderador owner, BindingResult result) {
        System.out.println(owner);
        System.out.println(result);
        return null;

//        if (result.hasErrors()) {
//            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
//        }
//        else {
//            //creating owner, user and authorities
//            this.ownerService.saveOwner(owner);
//
//            return "redirect:/owners/" + owner.getId();
//        }
    }*/
}

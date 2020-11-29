package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Organizacion;
import org.springframework.samples.petclinic.model.Usuario;
import org.springframework.samples.petclinic.service.OrganizacionService;
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
public class OrganizacionController {

    private static final String VIEWS_ORGANIZACION_CREATE_FORM = "users/registerOrganizacionForm";

    private final OrganizacionService organizacionService;

    @Autowired
    public OrganizacionController(OrganizacionService organizacionService) {
        this.organizacionService = organizacionService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping(value = "/users/new_organizacion" )
    public String initCreationForm(Map<String, Object> model) {
        Organizacion organizacion = new Organizacion();
        model.put("organizacion", organizacion);
        return VIEWS_ORGANIZACION_CREATE_FORM ;
    }

    @PostMapping(value = "/users/new_organizacion")
    public String processCreationForm(@Valid Organizacion organizacion, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_ORGANIZACION_CREATE_FORM ;
        }
        else {
            //creating Organizacion, user,
            this.organizacionService.saveOrganizacion(organizacion);
            return "redirect:/";
        }
    }
}

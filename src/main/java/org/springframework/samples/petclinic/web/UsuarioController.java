package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Usuario;
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
public class UsuarioController {

    private static final String VIEWS_USUARIO_CREATE_FORM = "users/registerUsuarioForm";

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @GetMapping(value = "/users/new_usuario")
    public String initCreationForm(Map<String, Object> model) {
        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        return VIEWS_USUARIO_CREATE_FORM ;
    }

    @PostMapping(value = "/users/new_usuario")
    public String processCreationForm(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_USUARIO_CREATE_FORM ;
        }
        else {
            //creating Usuario, user,
            this.usuarioService.saveUsuario(usuario);
            return "redirect:/";
        }
    }


}

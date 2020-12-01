package org.springframework.samples.petclinic.web;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.samples.petclinic.model.Actor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping({"/","/welcome"})
	public String welcome(Map<String, Object> model) {

		ArrayList<Actor> lista = new ArrayList<Actor>();
		Actor actor1 = new Actor();
		Actor actor2 = new Actor();
		Actor actor3 = new Actor();
		Actor actor4 = new Actor();
		Actor actor5 = new Actor();
		Actor actor6 = new Actor();
		
		actor1.setNombre("Javier Perez Martin");
		lista.add(actor1);
		
		actor2.setNombre("Pablo Quindós");
		lista.add(actor2);
		
		actor3.setNombre("Siamion Danko");
		lista.add(actor3);
		
		actor4.setNombre("Luis Rodriguez Vidosa");
		lista.add(actor4);
		
		actor5.setNombre("Ayman Alaoui Mhammedi");
		lista.add(actor5);
		
		actor6.setNombre("Javier Centeno Vega");
		lista.add(actor6);
		
		model.put("persons",lista);
		model.put("title", "DP1-PetClinic");
		model.put("group", "G1-06");
		
		return "welcome";
	}

}

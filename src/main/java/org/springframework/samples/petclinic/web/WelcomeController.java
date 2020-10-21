package org.springframework.samples.petclinic.web;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.samples.petclinic.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class WelcomeController {

	//*En el método del controlador WelcomeController crearemos una lista de Person.
    //Añadiremos un objeto Person con los datos de cada miembro del equipo a dicha lista.

    //Posteriormente añadiremos la lista de personas, el título del proyecto, y el nombre del grupo al
    //mapa del modelo (que nos permite transmitirle información a la vista).*/

	  @GetMapping({"/","/welcome"})
	  public String welcome(Map<String, Object> model) {

	      ArrayList<Person> lista = new ArrayList<Person>();
	      Person person1 = new Person();
          Person person2 = new Person();
          Person person3 = new Person();
          Person person4 = new Person();
          Person person5 = new Person();
          Person person6 = new Person();

	      person1.setFirstName("Javier");
	      person1.setLastName("Perez Martin");
	      lista.add(person1);

	      person2.setFirstName("Pablo");
	      person2.setLastName("Quindós");
	      lista.add(person2);

	      person3.setFirstName("Siamion");
	      person3.setLastName("Danko");
	      lista.add(person3);

          person4.setFirstName("Luis");
          person4.setLastName("Rodriguez Vidosa");
          lista.add(person4);

          person5.setFirstName("Ayman");
          person5.setLastName("Alaoui Mhammedi");
          lista.add(person5);

          person6.setFirstName("Javier");
          person6.setLastName("Centeno Vega");
          lista.add(person6);

	      model.put("persons",lista);
	      model.put("title","My project");
	      model.put("group","G1-06");

	    return "welcome";
	  }
}

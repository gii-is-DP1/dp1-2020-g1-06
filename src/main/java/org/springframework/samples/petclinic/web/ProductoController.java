/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import java.util.Map;
import java.util.Optional;
import org.springframework.samples.petclinic.service.AuthoritiesService;
import org.springframework.samples.petclinic.service.ProductoService;

@Controller
public class ProductoController {

	private static final String VIEWS_PRODUCTO_CREATE_FORM = "producto/createProductoForm";

	private final ProductoService productoService;

	@Autowired
	public ProductoController(final ProductoService productoService, final AuthoritiesService authoritiesService) {
		this.productoService = productoService;
	}

	// Métodos de creación de producto

	@InitBinder
	public void setAllowedFields(final WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping(value = "/producto/new")
	public String initCreationForm(final Map<String, Object> model) {
		Producto producto = new Producto();
		model.put("producto", producto);
		return ProductoController.VIEWS_PRODUCTO_CREATE_FORM;
	}

	@PostMapping(value = "/producto/new")
	public String processCreationForm(@Valid final Producto producto, final BindingResult result) {
		String view = "redirect:/producto/list";
		if (result.hasErrors()) {
			return ProductoController.VIEWS_PRODUCTO_CREATE_FORM;
		} else {
			//Actor actor = this.actorService.findActorByLogedUser();
			//producto.setActor(actor);
			this.productoService.saveProducto(producto);
			return view;
		}
	}
	@GetMapping(path = "/producto/list")
	public String deleteProducto(@PathParam)

	// Otros métodos

	@GetMapping("/producto/view/{productoId}")
	public ModelAndView viewProducto(@PathVariable("productoId") int productoId) {
		ModelAndView mav = new ModelAndView("producto/viewProducto");
		Optional<Producto> producto = this.productoService.findProductoById(productoId);
		// TODO: y si no hay un producto?
		mav.addObject("producto", producto.get());
		return mav;
	}

	@GetMapping("/producto/list")
	public ModelAndView listProductos() {
		ModelAndView mav = new ModelAndView("producto/listProductos");
		mav.addObject("productos", this.productoService.findAllWithAmount());
		return mav;
	}

	@GetMapping("/producto/search")
	public ModelAndView searchProductos(@RequestParam String searchQuery) {
		ModelAndView mav = new ModelAndView("producto/listProductos");
		mav.addObject("productos", this.productoService.findBySearchString(searchQuery));
		return mav;
	}

}

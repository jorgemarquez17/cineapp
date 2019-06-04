package cl.duoc.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cl.duoc.app.model.Contacto;
import cl.duoc.app.model.Horario;
import cl.duoc.app.model.Pelicula;
import cl.duoc.app.service.IPeliculaService;

@Controller
public class ContactoController {
	
	@Autowired
	IPeliculaService servicePeliculas;
	
	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute("instanciaContacto") Contacto contacto,Model model) {
		
		model.addAttribute("generos",servicePeliculas.buscarGenero());
		model.addAttribute("tipos", tipoNotificaciones());
		
		return "formContacto";
	}
	
	@PostMapping("/contacto")
	public String guardar(@ModelAttribute("instanciaContacto") Contacto contacto) {
		//model.addAttribute("generos",servicePeliculas.buscarGenero());
		// Este objeto ya se podria almacenar
		System.out.println(contacto);
		return "redirect:/contacto";
	}
	
	public List<String> tipoNotificaciones(){
		//Nota: la lista se podria generar apartir de una BD
		List<String> tipos = new LinkedList<String>();
		tipos.add("Estrenos");
		tipos.add("Promociones");
		tipos.add("Noticias");
		tipos.add("Preventas");
		return tipos;
	}
	
	/*
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Horario horario, Model model) {
		List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", listaPeliculas);
		return "horarios/formHorario";
	}*/
	
	

}

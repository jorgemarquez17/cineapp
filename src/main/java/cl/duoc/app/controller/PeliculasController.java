package cl.duoc.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.duoc.app.model.Pelicula;
import cl.duoc.app.service.IPeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@Autowired
	private IPeliculaService servicePelicula;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> lista = servicePelicula.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}
	
	@GetMapping("/create")
	public String crear() {
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String guardar(Pelicula pelicula, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Existieron Errores");
			return "peliculas/formPelicula";
		}
		/*for(ObjectError error : result.getAllErrors()) {
			System.out.println("Descripcion del Error : "+error.getDefaultMessage());
		}*/
		
		System.out.println("Recibiendo objeto pelicula : " + pelicula);
		
		System.out.println("Elementos de la lista Antes de la insercion: " + servicePelicula.buscarTodas().size());
		servicePelicula.insertar(pelicula);	
		System.out.println("Elementos de la lista Despues de la insercion: " + servicePelicula.buscarTodas().size());
		//return "peliculas/formPelicula";
		return "redirect:/peliculas/index";
	}
	
	@InitBinder
	public void initbinder(WebDataBinder binder) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}

package cl.duoc.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.duoc.app.model.Pelicula;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@GetMapping("/create")
	public String crear() {
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String guardar(Pelicula pelicula, BindingResult result) {
		
		/*if(result.hasErrors()) {
			System.out.println("Existieron Errores");
			return "peliculas/formPelicula";
		}*/
		for(ObjectError error : result.getAllErrors()) {
			System.out.println("Descripcion del Error : "+error.getDefaultMessage());
		}
		
		System.out.println("Recibiendo objeto pelicula : " + pelicula);
		return "peliculas/formPelicula";
	}

}

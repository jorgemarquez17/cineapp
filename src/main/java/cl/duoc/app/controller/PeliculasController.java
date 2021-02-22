package cl.duoc.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import cl.duoc.app.model.Pelicula;
import cl.duoc.app.service.IDetallesService;
import cl.duoc.app.service.IPeliculaService;
import cl.duoc.app.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@Autowired
	private IDetallesService serviceDetalle;
	
	@Autowired
	private IPeliculaService servicePelicula;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> lista = servicePelicula.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {
		
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			System.out.println("Existieron Errores");
			return "peliculas/formPelicula";
		}
		if(!multiPart.isEmpty()) { //Esto el objeto multipart no esta vacio siginfica que el usuario selecciono una imagen
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			pelicula.setImagen(nombreImagen);
		}		

		serviceDetalle.insertar(pelicula.getDetalle());
		
		servicePelicula.insertar(pelicula);	
		
		attributes.addFlashAttribute("mensaje", "El Registro fue guardado");
		//return "peliculas/formPelicula";
		return "redirect:/peliculas/index";
	}	
	
	@GetMapping(value="/edit/{id}")
	public String editar(@PathVariable("id") int idPelicula, Model model) {
		
		Pelicula pelicula = servicePelicula.buscarPorId(idPelicula);
		model.addAttribute("pelicula",pelicula);
		return "peliculas/formPelicula";
	}
	
	@GetMapping(value="/delete/{id}")
	public String eliminar(@PathVariable("id") int idPelicula, RedirectAttributes attributes) {
		
		Pelicula pelicula = servicePelicula.buscarPorId(idPelicula);
		// primero elimnar la pelicula
		servicePelicula.eliminar(idPelicula);
		//Despues se elimina el detalle
		serviceDetalle.eliminar(pelicula.getDetalle().getId());
		attributes.addFlashAttribute("mensaje", "La pelicula fue eliminada");
		return "redirect:/peliculas/index";
	}
	
	@GetMapping(value="/indexPaginate")
	public String mostrarIndexPAginado(Model model,Pageable page) {
		Page<Pelicula> lista = servicePelicula.buscarTodas(page);
		model.addAttribute("peliculas",lista.getContent());
		return "peliculas/listPeliculas";
	}
	
	@ModelAttribute("generos")
	public List<String> getGeneros(){
		return servicePelicula.buscarGenero();
	}

	@InitBinder
	public void initbinder(WebDataBinder binder) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}

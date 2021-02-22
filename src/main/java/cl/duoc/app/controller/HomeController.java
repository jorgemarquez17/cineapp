package cl.duoc.app.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.duoc.app.model.Horario;
import cl.duoc.app.model.Pelicula;
import cl.duoc.app.service.IBannersService;
import cl.duoc.app.service.IHorarioServices;
import cl.duoc.app.service.IPeliculaService;
import cl.duoc.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculaService servicePeliculas;
	
	@Autowired
	private IBannersService serviceBanners;
	
	@Autowired
	private IHorarioServices serviceHorario;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String buscar(Model model,@RequestParam("fecha") Date fecha) {
		
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas =servicePeliculas.buscarTodas();
		
		model.addAttribute("fechas",listaFechas);
		model.addAttribute("fechaBusqueda",dateFormat.format(fecha));
		model.addAttribute("peliculas", peliculas);		
		model.addAttribute("listBanners",serviceBanners.buscarTodos());// Ejercicio Solucion 

		return "home";
	}

	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		

		model.addAttribute("fechas",listaFechas);
		model.addAttribute("fechaBusqueda",dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("listBanners",serviceBanners.buscarTodos());

		return "home";
	}

	@RequestMapping(value = "/detail/{id}/{fecha}",method=RequestMethod.GET) //-->Parametro Dinamicos
	public String mostrarDetalle(Model model,@PathVariable("id") int idPelicula,@PathVariable("fecha") Date fecha) {
		List<Horario> horarios= serviceHorario.buscarPorIdPelicula(idPelicula,fecha);
		Pelicula peli = servicePeliculas.buscarPorId(idPelicula);
		System.out.println("test idPelicula : "+ idPelicula);
		System.out.println("test fecha : "+dateFormat.format(fecha));
		System.out.println("test hora pelicula: "+horarios.size());
		System.out.println("xxxPeliculaxxx: "+peli.toString());
		model.addAttribute("horarios",horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		model.addAttribute("pelicula",peli);
		
		return "detalle";
	}
	
	@InitBinder
	public void initbinder(WebDataBinder binder) {
		
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}

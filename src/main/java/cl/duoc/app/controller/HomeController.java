package cl.duoc.app.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import cl.duoc.app.model.Pelicula;
import cl.duoc.app.service.IBannersService;
import cl.duoc.app.service.IPeliculaService;
import cl.duoc.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculaService servicePeliculas;
	
	@Autowired
	private IBannersService serviceBanners;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String buscar(Model model,@RequestParam("fecha") String fecha) {
		
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas =servicePeliculas.buscarTodas();
		
		model.addAttribute("fechas",listaFechas);
		model.addAttribute("fechaBusqueda",fecha);
		model.addAttribute("peliculas", peliculas);		
		model.addAttribute("banners",serviceBanners.buscarTodos());// Ejercicio Solucion 

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
	//@RequestMapping(value = "/detail",method = RequestMethod.GET)
	public String mostrarDetalle(Model model,@PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha) {
	//public String mostrarDetalle(Model model,@RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) {
		
		System.out.println("Buscando Horarios para la pelicula:  "+ idPelicula);
		System.out.println("Para la fecha : "+ fecha);
		
		model.addAttribute("pelicula",servicePeliculas.buscarPorId(idPelicula));
		
		return "detalle";
	}
}

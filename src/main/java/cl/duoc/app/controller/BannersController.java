package cl.duoc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.duoc.app.model.Banner;
import cl.duoc.app.service.IBannersService;

@Controller
@RequestMapping("/banners/")
public class BannersController {

	// Ejercicio: Inyectar instancia de la clase de servicio
        @Autowired	
		private IBannersService serviceBanners;
	/**
	 * Metodo para mostrar el listado de banners
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		
		// Ejercicio: Implementar metodo
		List<Banner> banners = serviceBanners.buscarTodos();
		model.addAttribute("banners", banners);
		
		// Ejercicio: Crear vista listBanners.jsp. Utilizar el archivo listBanners.html de la plantilla 
		return "banners/listBanners";
	}
	
	/**
	 * Metodo para mostrar el formulario para crear un nuevo Banner
	 * @return
	 */
	@GetMapping("/create")
	public String crear() {
		
		// Ejercicio: Crear vista formBanner.jsp. Utilizar el archivo formBanner.html de la plantilla 
		return "banners/formBanner";
		
	}
	
	/**
	 * Metodo para guardar el objeto de modelo de tipo Banner
	 * @return
	 */
	@PostMapping("/save")
	public String guardar() {
		
		// Ejercicio: Implementar el metodo.
		
		return "redirect:/banners/index";
	}	
}

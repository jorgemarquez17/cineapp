package cl.duoc.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/horarios")
public class HorariosController {
		
	/**
	 * Metodo para mostrar el formulario para crear un nuevo horario
	 * @return
	 */
	@GetMapping(value = "/create")
	public String crear() {
		
		// Ejercicio: Recuperar lista de peliculas para poblar <select>
				
		// Ejercicio: agregar al modelo listado de peliculas
		
		// Ejercicio: crear archivo formHorario.jsp y configurar el dise�o utilizando el codigo HTML
		// del archivo formHorario.html de la plantilla (utilizar Form Tag Library)
		
		return "horarios/formHorario";
	}
		
	/**
	 * Metodo para guardar el registro del Horario
	 * @param horario
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/save")
	public String guardar() {				
		
		// Ejercicio: Verificar si hay errores en el Data Binding
		
		// Ejercicio: En caso de no haber errores, imprimir en consola el objeto de model Horario 
		// que ya debera de tener los datos del formulario
				
		// De momento, hacemos un redirect al mismo formulario 
		return "redirect:/horarios/create";
	}
	
	// Ejercicio: Crear metodo para personalizar el Data Binding para las todas las propiedades de tipo Date	
	
}

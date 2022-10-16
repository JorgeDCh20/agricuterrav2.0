package pe.edu.upc.agricuterra.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.agricuterra.entities.Analisis;
import pe.edu.upc.agricuterra.entities.Proyeccion;
import pe.edu.upc.agricuterra.serviceinterfaces.IAnalisisService;
import pe.edu.upc.agricuterra.serviceinterfaces.IProyeccionService;

@Controller
@RequestMapping("/pproyecciones")
public class ProyeccionController {

	@Autowired
	private IProyeccionService proyeccionService;
	
	@Autowired
	private IAnalisisService analisisService;
	
	@RequestMapping("/gonew/{id}")
	public String gonew(@PathVariable int id, Model model) {
		Optional<Analisis> objAna= analisisService.listId(id);
		model.addAttribute("pr", objAna.get());
		model.addAttribute("p", new Proyeccion());
		return "proyeccion/frmRegistro";
	}
	
	
	

	@PostMapping("/save")
	public String saveProyeccion(@Valid Proyeccion pr, BindingResult binRes, Model model, RedirectAttributes attribute) {
		if (binRes.hasErrors()) {
			return "proyeccion/frmRegistro";
		} else {
			proyeccionService.insert(pr);
			model.addAttribute("mensaje", "Se registró correctamente");
			attribute.addFlashAttribute("success", "Se registró correctamente.");

			return "redirect:/pproyecciones/list";
		}
	}

	@GetMapping("/list")
	public String listProyeccion(Model model) {
		try {
			model.addAttribute("listaProyecciones", proyeccionService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "proyeccion/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteProyeccion(Map<String, Object> model, @RequestParam(value = "id") Integer id, RedirectAttributes attribute) {
		try {
			if (id != null && id > 0) {
				proyeccionService.delete(id);
				model.put("listaProyecciones", proyeccionService.list());
				model.put("warning", "Registro eliminado correctamente.");
				
			}
		} catch (Exception e) {
			model.put("error", "El registro tiene dependencias, no se puede eliminar.");
		}
		return "proyeccion/frmLista";
	}
	// modificaraaa

	@RequestMapping("/goupdate/{id}")
	public String goUpdatePerson(@PathVariable int id, Model model) {
		Optional<Proyeccion> objPro = proyeccionService.listId(id);
		model.addAttribute("pr", objPro.get());
		return "proyeccion/frmActualiza";
	}

	// este va a guardar los cambios y se actuliza en la base de datos
	@PostMapping("/update")
	public String updateProyeccion(Proyeccion p, RedirectAttributes attribute) {
		proyeccionService.update(p);
		attribute.addFlashAttribute("success", "Se modificó correctamente.");
		return "redirect:/pproyecciones/list";
	}

}

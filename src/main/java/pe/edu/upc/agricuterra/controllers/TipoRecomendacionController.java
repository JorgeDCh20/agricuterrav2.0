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

import pe.edu.upc.agricuterra.entities.TipoRecomendacion;
import pe.edu.upc.agricuterra.serviceinterfaces.ITipoRecomendacionService;

@Controller
@RequestMapping("/ptiporecomendacion")
public class TipoRecomendacionController {

	@Autowired
	private ITipoRecomendacionService tipoService;

	@GetMapping("/new")
	public String newTipoRecomendacion(Model model) {
		model.addAttribute("trm", new TipoRecomendacion());
		return "TipoRecomendacion/frmRegistro";
	}

	@PostMapping("/save")
	public String saveTipoRecomendacion(@Valid TipoRecomendacion tr, BindingResult binRes, Model model, RedirectAttributes attribute) {
		if (binRes.hasErrors()) {
			return "TipoRecomendacion/frmRegistro";
		} else {
			tipoService.insert(tr);
			model.addAttribute("mensaje", "Se registró correctamente");
			attribute.addFlashAttribute("success", "Se registró correctamente");
			return "redirect:/ptiporecomendacion/list";
		}
	}

	@GetMapping("/list")
	public String listTipoRecomendacion(Model model) {
		try {
			model.addAttribute("ListaTipoRecomendacion", tipoService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "TipoRecomendacion/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteTipoRecomendacion(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tipoService.delete(id);
				model.put("ListaTipoRecomendacion", tipoService.list());
				model.put("warning", "Registro eliminado correctamente.");
			}
		} catch (Exception e) {
			//model.put("error", e.getMessage());
			model.put("error", "El registro tiene dependencias, no se puede eliminar.");
		}
		return "TipoRecomendacion/frmLista";
	}
	
	//va a llevar el objeto y lo va a mostrar en el formulario
	@RequestMapping("/goupdate/{id}")
	public String goUpdateTipoRecomendacion(@PathVariable int id, Model model) {
		
		Optional<TipoRecomendacion>objTR=tipoService.listId(id);
		model.addAttribute("tru", objTR.get());
		return "TipoRecomendacion/frmActualiza";
	}
	
	//guardar los cambios
	@PostMapping("/update")
	public String updateTipoRecomendacion(TipoRecomendacion t, RedirectAttributes attribute) {
		tipoService.update(t);
		attribute.addFlashAttribute("success", "Se modificó correctamente.");
		return "redirect:/ptiporecomendacion/list";
	}
	
	
}

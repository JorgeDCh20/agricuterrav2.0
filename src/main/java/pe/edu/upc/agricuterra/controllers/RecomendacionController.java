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

import pe.edu.upc.agricuterra.entities.Recomendacion;
import pe.edu.upc.agricuterra.serviceinterfaces.IRecomendacionService;
import pe.edu.upc.agricuterra.serviceinterfaces.ITipoRecomendacionService;

@Controller
@RequestMapping("/rrecomendacion")
public class RecomendacionController {
	@Autowired
	private IRecomendacionService recomendacionService;
	@Autowired
	private ITipoRecomendacionService tipoRecomendacionService;
	
	@GetMapping("/new")
	public String newRecomendacion(Model model) {
		model.addAttribute("r", new Recomendacion());
		model.addAttribute("ListaTipoRecomendacion", tipoRecomendacionService.list());
		return "recomendacion/frmRegistro";
	}

	@PostMapping("/save")
	public String saveRecomendacion(@Valid Recomendacion re, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "recomendacion/frmRegistro";
			
		} else {
			recomendacionService.insert(re);
			model.addAttribute("success", "Se registró correctamente");
			return "redirect:/rrecomendacion/new";
		}
	}

	@GetMapping("/list")
	public String listRecomendacion(Model model) {
		try {
			model.addAttribute("listaRecomendaciones", recomendacionService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "recomendacion/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteRecomendacion(Map<String, Object> model, @RequestParam(value = "id") Integer id, Model anuncio) {
		try {
			if (id != null && id > 0) {
				recomendacionService.delete(id);
				model.put("listaRecomendaciones", recomendacionService.list());
				anuncio.addAttribute("warning", "Registro eliminado correctamente.");
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "recomendacion/frmLista";
	}


	@RequestMapping("/goupdate/{id}") 
	public String goUpdateRecomendacion(@PathVariable int id, Model model) {
		Optional<Recomendacion> objRec = recomendacionService.listId(id);
		model.addAttribute("ListaTipoRecomendacion", tipoRecomendacionService.list());
		model.addAttribute("re", objRec.get());
		return "recomendacion/frmActualiza";
	}

	@PostMapping("/update")
	public String updateRecomendacion(Recomendacion r) {
		recomendacionService.update(r);
		return "redirect:/rrecomendacion/list";
	}

}

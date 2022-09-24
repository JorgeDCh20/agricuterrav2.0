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

import pe.edu.upc.agricuterra.entities.Sembrio;
import pe.edu.upc.agricuterra.serviceinterfaces.ISembrioService;

@Controller
@RequestMapping("/psembrios")
public class SembrioController {

	@Autowired
	private ISembrioService sembrioService;

	@GetMapping("/new")
	public String newSembrio(Model model) {
		model.addAttribute("s", new Sembrio());
		return "sembrio/frmRegistro";
	}

	@PostMapping("/save")
	public String saveSembrio(@Valid Sembrio se, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "sembrio/frmRegistro";
		} else {
			sembrioService.insert(se);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "sembrio/frmRegistro";
		}
	}

	@GetMapping("/list")
	public String listSembrio(Model model) {
		try {
			model.addAttribute("listaSembrios", sembrioService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "sembrio/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteSembrio(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				sembrioService.delete(id);
				model.put("listaSembrios", sembrioService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "sembrio/frmLista";
	}
	
	//va a llevar el obj y lo va a mostrar en el formulario
	@RequestMapping("/goupdate/{id}")
	public String goUpdateSembrio(@PathVariable int id, Model model) {
		Optional<Sembrio> objSem=sembrioService.ListId(id);
		model.addAttribute("se", objSem.get());
		return "sembrio/frmActualiza";
	}
	
	//va a guardar los cambios
	@PostMapping("/update")
	public String updateSembrio(Sembrio s) {
		sembrioService.update(s);
		return "redirect:/psembrios/list";
	}
	
}

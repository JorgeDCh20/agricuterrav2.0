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

import pe.edu.upc.agricuterra.entities.Analisis;
import pe.edu.upc.agricuterra.entities.Factor;
import pe.edu.upc.agricuterra.serviceinterfaces.IAnalisisService;
import pe.edu.upc.agricuterra.serviceinterfaces.IFactorService;
import pe.edu.upc.agricuterra.serviceinterfaces.ISembrioService;


@Controller
@RequestMapping("/panalisis")
public class AnalisisController {
	@Autowired
	private IAnalisisService analisisService;
	
	@Autowired
	private ISembrioService sembrioService;
	
	@Autowired
	private IFactorService factorService;
	
	
	@RequestMapping("/gonew/{id}") 
	public String goNew(@PathVariable int id, Model model) {
		Optional<Factor> objFac = factorService.listId(id);
		model.addAttribute("listaSembrios", sembrioService.list());
		model.addAttribute("fa", objFac.get());
		model.addAttribute("a", new Analisis());
		return "analisis/frmRegistro";
	}
	

	@PostMapping("/save")
	public String saveAnalisis(@Valid Analisis an, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "analisis/frmRegistro";
		} else {
			analisisService.insert(an);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/panalisis/list";
		}
	}
	

	@GetMapping("/list")
	public String listAnalisis(Model model) {
		try {
			model.addAttribute("listaAnalisis", analisisService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "analisis/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteAnalisis(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				analisisService.delete(id);
				model.put("listaAnalisis", analisisService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "analisis/frmLista";
	}


	@RequestMapping("/goupdate/{id}") 
	public String goUpdateAnalisis(@PathVariable int id, Model model) {
		Optional<Analisis> objAna = analisisService.listId(id);
		model.addAttribute("listaSembrios", sembrioService.list());
		model.addAttribute("listaFactores", factorService.list());
		model.addAttribute("an", objAna.get());
		return "analisis/frmActualiza";
	}

	@PostMapping("/update")
	public String updateAnalisis(Analisis a) {
		analisisService.update(a);
		return "redirect:/panalisis/list";
	}

}

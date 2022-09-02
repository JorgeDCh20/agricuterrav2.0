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

import pe.edu.upc.agricuterra.entities.TipoFactor;
import pe.edu.upc.agricuterra.serviceinterfaces.ITipoFactorService;

@Controller
@RequestMapping("/ttipofactores")
public class TipoFactorController {

	@Autowired
	private ITipoFactorService tfService;

	@GetMapping("/new")
	public String newTipoFactor(Model model) {
		model.addAttribute("tf", new TipoFactor());
		return "tipofactor/frmRegistro";
	}

	@PostMapping("/save")
	public String saveTipoFactor(@Valid TipoFactor tif, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "tipofactor/frmRegistro";
		} else {
			tfService.insert(tif);
			model.addAttribute("mensaje", "Se registró correctamente");
			return "redirect:/ttipofactores/new";
		}
	}

	@GetMapping("/list")
	public String listTipoFactor(Model model) {
		try {
			model.addAttribute("listaTipoFactores", tfService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "tipofactor/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteTipoFactor(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tfService.delete(id);
				model.put("listaTipoFactores", tfService.list());
			}

		} catch (Exception e) {
			model.put("error", e.getMessage());
		}

		return "tipofactor/frmLista";
	}

	// modificar
	@RequestMapping("/goupdate/{id}")
	public String goUpdateTipoFactor(@PathVariable int id, Model model) {

		Optional<TipoFactor> objTFr = tfService.listId(id);
		model.addAttribute("tif", objTFr.get());
		return "tipofactor/frmActualiza";
	}

	@PostMapping("/update")
	public String updateTipoFactor(TipoFactor tf) {

		tfService.update(tf);
		return "redirect:/ttipofactores/list";

	}

}

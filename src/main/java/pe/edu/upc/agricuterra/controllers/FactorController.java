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

import pe.edu.upc.agricuterra.entities.Factor;
import pe.edu.upc.agricuterra.serviceinterfaces.IFactorService;
import pe.edu.upc.agricuterra.serviceinterfaces.ITipoFactorService;
import pe.edu.upc.agricuterra.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/ffactores")
public class FactorController {

	@Autowired
	private ITipoFactorService tfService;

	@Autowired
	private IFactorService fService;
	
	@Autowired
	private IUsuarioService uService;

	@GetMapping("/new")
	public String newFactor(Model model) {
		model.addAttribute("f", new Factor());
		model.addAttribute("listaTipoFactores", tfService.list());
        model.addAttribute("listaUsuarios", uService.list());
        
		return "factor/frmRegistro";
	}

	@PostMapping("/save")
	public String saveFactor(@Valid Factor objFact, BindingResult binRes, Model model) {

		if (binRes.hasErrors()) {
			return "/factor/frmRegistro";
		} else {
			fService.insert(objFact);
		}

		return "redirect:/ffactores/new";
	}

	@GetMapping("/list")
	public String listFactor(Model model) {

		try {
			model.addAttribute("listaFactores", fService.list());

		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		}

		return "factor/frmLista";

	}

	@RequestMapping("/delete")
	public String deleteFactor(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				fService.delete(id);
				model.put("listaFactores", fService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "factor/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateFactor(@PathVariable int id, Model model) {
		Optional<Factor> objFac = fService.listId(id);
		model.addAttribute("listaTipoFactores", tfService.list());
		model.addAttribute("listaUsuarios", uService.list());
		model.addAttribute("fac", objFac.get());
				
		return "factor/frmActualiza";
	}
//posible problemas a futuro aqui :v
	@PostMapping("/update")
	public String updateFactor(Factor f) {
		fService.update(f);
		return "redirect:/ffactores/list";

	}
}

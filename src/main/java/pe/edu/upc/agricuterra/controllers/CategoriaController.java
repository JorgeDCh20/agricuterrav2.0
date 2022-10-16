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

import pe.edu.upc.agricuterra.entities.Categoria;
import pe.edu.upc.agricuterra.serviceinterfaces.ICategoriaService;

@Controller
@RequestMapping("/ccategorias")
public class CategoriaController {
	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping("/new")
	public String newCategoria(Model model) {
		model.addAttribute("c", new Categoria());
		return "categoria/frmRegistro";
	}

	@PostMapping("/save")
	public String saveCategoria(@Valid Categoria ca, BindingResult binRes, Model model, RedirectAttributes attribute) {
		if (binRes.hasErrors()) {
			return "categoria/frmRegistro";
		} else {
			categoriaService.insert(ca);
			model.addAttribute("mensaje", "Se registró correctamente");
			attribute.addFlashAttribute("success", "Se registró correctamente.");
			return "redirect:/ccategorias/new";
		}
	}

	@GetMapping("/list")
	public String listCategoria(Model model) {
		try {
			model.addAttribute("listaCategorias", categoriaService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "categoria/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteCategoria(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				categoriaService.delete(id);
				model.put("listaCategorias", categoriaService.list());
				model.put("warning", "Registro eliminado correctamente.");
			}
		} catch (Exception e) {
			model.put("error", "El registro tiene dependencias, no se puede eliminar.");
		}
		return "redirect:/ccategorias/list";
	}


	@RequestMapping("/goupdate/{id}") 
	public String goUpdateCategoria(@PathVariable int id, Model model) {
		Optional<Categoria> objCat = categoriaService.listId(id);
		model.addAttribute("ca", objCat.get());
		return "categoria/frmActualiza";
	}

	@PostMapping("/update")
	public String updateCategoria(Categoria c, RedirectAttributes attribute) {
		categoriaService.update(c);
		attribute.addFlashAttribute("success", "Se modificó correctamente.");
		return "redirect:/ccategorias/list";
	}

}

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

import pe.edu.upc.agricuterra.entities.RecoXUsuario;
import pe.edu.upc.agricuterra.serviceinterfaces.IRecoXUsuarioService;
import pe.edu.upc.agricuterra.serviceinterfaces.IRecomendacionService;
import pe.edu.upc.agricuterra.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/precomendacionXusuario")
public class RecoXUsuarioController {

	@Autowired
	private IRecoXUsuarioService recoxusuarioService;
	@Autowired
	private IRecomendacionService recomendacionService;
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/new")
	public String newRecoXUsuario (Model model) {
		model.addAttribute("ru", new RecoXUsuario());
		model.addAttribute("listaRecomendaciones", recomendacionService.list());
		model.addAttribute("listaUsuarios", usuarioService.list());
		return "RecoXUsuario/frmRegistro";
	}
	
	@PostMapping("/save")
	public String saveRecoXUsuario (@Valid RecoXUsuario objrecoxusuario, BindingResult binRes, Model model, RedirectAttributes attribute) {
		if (binRes.hasErrors()) {
			return "/RecoXUsuario/frmRegistro";
		} else {
			recoxusuarioService.insert(objrecoxusuario);
			model.addAttribute("mensaje", "Se registro correctamente");
			attribute.addFlashAttribute("success", "Se registró correctamente.");
			return "redirect:/precomendacionXusuario/new";
		}
	}
	
	@GetMapping("/list")
	public String listRecoXUsuario (Model model) {
		try {
			model.addAttribute("listaRecoXUsuarios", recoxusuarioService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "RecoXUsuario/frmLista";
	}
	
	@RequestMapping("/delete")
	public String deleteRecoXUsuario(Map<String, Object> model, @RequestParam(value = "id") Integer id, RedirectAttributes attribute) {
		try {
			if (id != null && id > 0) {
				recoxusuarioService.delete(id);
				model.put("listaRecoXUsuarios", recoxusuarioService.list());
				model.put("warning", "Registro eliminado correctamente.");
				
			}
		} catch (Exception e) {
			model.put("error", "El registro tiene dependencias, no se puede eliminar.");
		}
		return "RecoXUsuario/frmLista";
	}
	
	@RequestMapping("/goupdate/{id}")
	public String goUpdateRecoXUsuario(@PathVariable int id, Model model) {
		Optional<RecoXUsuario> objRXU = recoxusuarioService.listID(id);
		model.addAttribute("listaRecomendaciones", recomendacionService.list());
		model.addAttribute("listaUsuarios", usuarioService.list());
		model.addAttribute("rup", objRXU.get());
		return "RecoXUsuario/frmActualiza";
	}
	
	@PostMapping("/update")
	public String updateRecoXUsuario(RecoXUsuario ru, RedirectAttributes attribute) {
		recoxusuarioService.update(ru);
		attribute.addFlashAttribute("success", "Se modificó correctamente.");
		return "redirect:/precomendacionXusuario/list";
	}
	
}

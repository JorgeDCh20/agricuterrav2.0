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

import pe.edu.upc.agricuterra.entities.Usuario;
import pe.edu.upc.agricuterra.serviceinterfaces.ICategoriaService;
import pe.edu.upc.agricuterra.serviceinterfaces.IUsuarioService;

@Controller
@RequestMapping("/pusuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping("/new")
	public String newUsuario(Model model) {
		model.addAttribute("u", new Usuario());
		model.addAttribute("listaCategorias", categoriaService.list());
		return "usuario/frmRegistro";
	}

	@PostMapping("/save")
	public String saveUsuario(@Valid Usuario u, BindingResult binRes, Model model, RedirectAttributes attribute) {
		if (binRes.hasErrors()|| u.getCategoria().getIdCategoria()==1) {
			model.addAttribute("mensaje", "ROL INADECUADO");
			attribute.addFlashAttribute("error", "Para registrar un usuario ADMINISTRADOR hable con los creadores del programa.");
			return "redirect:/pusuarios/new";
		} else {
			usuarioService.insert(u);
			model.addAttribute("mensaje", "Se registró correctamente");
			attribute.addFlashAttribute("success", "Se registró correctamente");
			return "redirect:/";
		}
	}

	@GetMapping("/list")
	public String listUsuario(Model model) {
		try {
			model.addAttribute("listaUsuarios", usuarioService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "usuario/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteUsuario(Map<String, Object> model, @RequestParam(value = "id") Integer id, RedirectAttributes attribute) {
		try {
			if (id != null && id > 0) {
				usuarioService.delete(id);
				model.put("listaUsuarios", usuarioService.list());
				attribute.addFlashAttribute("warning", "Hecho");
			}
		} catch (Exception e) {
			model.put("ERROR", e.getMessage());
			attribute.addFlashAttribute("error", "No se puede eliminar, tiene dependencias");
			
		}
		return "usuario/frmLista";
	}

	@RequestMapping("/goupdate/{id}")
	public String goUpdateUsuario(@PathVariable int id, Model model) {
		Optional<Usuario> objUser = usuarioService.listId(id);
		model.addAttribute("listaCategorias", categoriaService.list());
		model.addAttribute("us", objUser.get());
		return "usuario/frmActualiza";
	}

	@PostMapping("/update")
	public String updateUsuario(Usuario usuario) {
		usuarioService.update(usuario);
		return "redirect:/pusuarios/list";
	}
}

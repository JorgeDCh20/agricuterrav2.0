package pe.edu.upc.agricuterra.serviceimplements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.agricuterra.entities.Categoria;
import pe.edu.upc.agricuterra.entities.Role;
import pe.edu.upc.agricuterra.entities.Usuario;
import pe.edu.upc.agricuterra.repositories.ICategoriaRepository;
import pe.edu.upc.agricuterra.repositories.IRoleRepository;
import pe.edu.upc.agricuterra.repositories.IUsuarioRepository;
import pe.edu.upc.agricuterra.serviceinterfaces.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	private ICategoriaRepository categoriaRepository ;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Override
	public void insert(Usuario usuario) {
		
		Usuario objUsuario = usuario;
		objUsuario.setPasswordUsuario(passwordEncoder.encode(objUsuario.getPasswordUsuario()));		
		objUsuario.setEnabled(true);
		Role rol = new Role();
		Categoria categoria = categoriaRepository.findById(objUsuario.getCategoria().getIdCategoria()).get();
		rol.setRol(categoria.getNameCategoria());
		rol = roleRepository.save(rol);
		
		objUsuario.setRoles(new ArrayList<Role>());
		objUsuario.getRoles().add(rol);
		objUsuario = usuarioRepository.save(objUsuario);
	}

	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();

	}

	@Override
	public void delete(int idUsuario) {
		usuarioRepository.deleteById(idUsuario);
		
	}

	@Override
	public Optional<Usuario> listId(int idUsuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(idUsuario);
	}

	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usuario);
	}

}

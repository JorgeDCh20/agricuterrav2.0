package pe.edu.upc.agricuterra.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.agricuterra.entities.Usuario;

public interface IUsuarioService {

	public void insert(Usuario usuario);

	public List<Usuario> list();
	
	public void delete(int idUsuario);
	
	Optional<Usuario> listId(int idUsuario);
	
	public void update(Usuario usuario);
}

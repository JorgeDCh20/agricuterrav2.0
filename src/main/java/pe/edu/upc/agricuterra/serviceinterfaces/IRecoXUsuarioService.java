package pe.edu.upc.agricuterra.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.agricuterra.entities.RecoXUsuario;

public interface IRecoXUsuarioService {

	public void insert(RecoXUsuario recoxusuario);
	
	public List<RecoXUsuario> list();
	public void delete(int idRecoXUsuario);
	Optional<RecoXUsuario> listID (int idRecoXUsuario);
	public void update(RecoXUsuario recoxusuario);
}

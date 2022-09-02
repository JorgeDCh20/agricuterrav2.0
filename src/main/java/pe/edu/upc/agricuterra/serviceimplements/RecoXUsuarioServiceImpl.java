package pe.edu.upc.agricuterra.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.agricuterra.entities.RecoXUsuario;
import pe.edu.upc.agricuterra.repositories.IRecoXUsuarioRepository;
import pe.edu.upc.agricuterra.serviceinterfaces.IRecoXUsuarioService;

@Service
public class RecoXUsuarioServiceImpl implements IRecoXUsuarioService{

	@Autowired
	private IRecoXUsuarioRepository recoxusuarioRepository;
	
	@Override
	public void insert(RecoXUsuario recoxusuario) {
		// TODO Auto-generated method stub
		recoxusuarioRepository.save(recoxusuario);
	}

	@Override
	public List<RecoXUsuario> list() {
		// TODO Auto-generated method stub
		return recoxusuarioRepository.findAll();
	}

	@Override
	public void delete(int idRecoXUsuario) {
		// TODO Auto-generated method stub
		recoxusuarioRepository.deleteById(idRecoXUsuario);
	}

	@Override
	public Optional<RecoXUsuario> listID(int idRecoXUsuario) {
		// TODO Auto-generated method stub
		return recoxusuarioRepository.findById(idRecoXUsuario);
	}

	@Override
	public void update(RecoXUsuario recoxusuario) {
		// TODO Auto-generated method stub
		recoxusuarioRepository.save(recoxusuario);
	}

}

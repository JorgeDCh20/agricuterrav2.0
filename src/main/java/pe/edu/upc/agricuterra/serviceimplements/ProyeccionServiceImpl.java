package pe.edu.upc.agricuterra.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.agricuterra.entities.Proyeccion;
import pe.edu.upc.agricuterra.repositories.IProyeccionRepository;
import pe.edu.upc.agricuterra.serviceinterfaces.IProyeccionService;

@Service
public class ProyeccionServiceImpl implements IProyeccionService {

	@Autowired
	private IProyeccionRepository proyeccionRepository;

	@Override
	public void insert(Proyeccion proyeccion) {
		// TODO Auto-generated method stub
		proyeccionRepository.save(proyeccion);

	}

	@Override
	public List<Proyeccion> list() {
		// TODO Auto-generated method stub
		return proyeccionRepository.findAll();
	}

	@Override
	public void delete(int idProyeccion) {
		// TODO Auto-generated method stub
		proyeccionRepository.deleteById(idProyeccion);

	}

	@Override
	public Optional<Proyeccion> listId(int idProyeccion) {
		// TODO Auto-generated method stub
		return proyeccionRepository.findById(idProyeccion);
	}

	@Override
	public void update(Proyeccion proyeccion) {
		// TODO Auto-generated method stub
		proyeccionRepository.save(proyeccion);

	}

}

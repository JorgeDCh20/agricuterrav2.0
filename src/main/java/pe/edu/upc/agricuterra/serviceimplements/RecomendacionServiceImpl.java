package pe.edu.upc.agricuterra.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.agricuterra.entities.Recomendacion;
import pe.edu.upc.agricuterra.repositories.IRecomendacionRepository;
import pe.edu.upc.agricuterra.serviceinterfaces.IRecomendacionService;

@Service
public class RecomendacionServiceImpl implements IRecomendacionService {
	@Autowired
	private IRecomendacionRepository recomendacionRepository;

	@Override
	public void insert(Recomendacion recomendacion) {
		recomendacionRepository.save(recomendacion);

	}

	@Override
	public List<Recomendacion> list() {
		// TODO Auto-generated method stub
		return recomendacionRepository.findAll();
	}

	@Override
	public void delete(int idRecomendacion) {
		// TODO Auto-generated method stub
		recomendacionRepository.deleteById(idRecomendacion);
	}

	@Override
	public Optional<Recomendacion> listId(int idRecomendacion) {
		// TODO Auto-generated method stub
		return recomendacionRepository.findById(idRecomendacion);
	}

	@Override
	public void update(Recomendacion recomendacion) {
		// TODO Auto-generated method stub
		recomendacionRepository.save(recomendacion);
	}

}

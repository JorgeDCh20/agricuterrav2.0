package pe.edu.upc.agricuterra.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.agricuterra.entities.TipoFactor;
import pe.edu.upc.agricuterra.repositories.ITipoFactorRepository;
import pe.edu.upc.agricuterra.serviceinterfaces.ITipoFactorService;

@Service
public class TipoFactorServiceImpl implements ITipoFactorService {

	@Autowired
	private ITipoFactorRepository tfRepository;
	
	@Override
	public void insert(TipoFactor tipofactor) {
		tfRepository.save(tipofactor);
		
	}

	@Override
	public List<TipoFactor> list() {
		return tfRepository.findAll();
	}

	@Override
	public void delete(int idTipoFactor) {
		tfRepository.deleteById(idTipoFactor);
		
	}

	@Override
	public Optional<TipoFactor> listId(int idTipoFactor) {
		return tfRepository.findById(idTipoFactor);
	}

	@Override
	public void update(TipoFactor tipofactor) {
		tfRepository.save(tipofactor);
		
	}

}

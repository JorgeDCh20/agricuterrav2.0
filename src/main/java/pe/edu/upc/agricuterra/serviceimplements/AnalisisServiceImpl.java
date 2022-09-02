package pe.edu.upc.agricuterra.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.agricuterra.entities.Analisis;
import pe.edu.upc.agricuterra.repositories.IAnalisisRepository;
import pe.edu.upc.agricuterra.serviceinterfaces.IAnalisisService;

@Service
public class AnalisisServiceImpl implements IAnalisisService {

	@Autowired
	private IAnalisisRepository analisisRepository;
	
	@Override
	public void insert(Analisis analisis) {
		analisisRepository.save(analisis);	
	}

	@Override
	public List<Analisis> list() {
		return analisisRepository.findAll();
	}

	@Override
	public void delete(int idAnalisis) {
		analisisRepository.deleteById(idAnalisis);
		
	}

	@Override
	public Optional<Analisis> listId(int idAnalisis) {
		return analisisRepository.findById(idAnalisis);
	}

	@Override
	public void update(Analisis analisis) {
		analisisRepository.save(analisis);		
	}

	
	

}

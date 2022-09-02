package pe.edu.upc.agricuterra.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.agricuterra.entities.Sembrio;
import pe.edu.upc.agricuterra.repositories.ISembrioRepository;
import pe.edu.upc.agricuterra.serviceinterfaces.ISembrioService;


@Service
public class SembrioServiceImpl implements ISembrioService {
	@Autowired
	private ISembrioRepository sembrioRepository;

	@Override
	public void insert(Sembrio sembrio) {
		sembrioRepository.save(sembrio);
	}

	@Override
	public List<Sembrio> list() {
		// TODO Auto-generated method stub
		return sembrioRepository.findAll();
	}

	@Override
	public void delete(int idSembrio) {
		// TODO Auto-generated method stub
		sembrioRepository.deleteById(idSembrio);
	}

	@Override
	public Optional<Sembrio> ListId(int idSembrio) {
		return sembrioRepository.findById(idSembrio);
	}

	@Override
	public void update(Sembrio sembrio) {
		sembrioRepository.save(sembrio);
	}

}

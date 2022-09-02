package pe.edu.upc.agricuterra.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.agricuterra.entities.Factor;
import pe.edu.upc.agricuterra.repositories.IFactorRepository;
import pe.edu.upc.agricuterra.serviceinterfaces.IFactorService;
@Service
public class FactorServiceImpl implements IFactorService{

	@Autowired
	private IFactorRepository fRepository;
	
	@Override
	public void insert(Factor factor) {
		// TODO Auto-generated method stub
		fRepository.save(factor);
	}

	@Override
	public List<Factor> list() {
		// TODO Auto-generated method stub
		return fRepository.findAll();
	}

	@Override
	public void delete(int idFactor) {
		// TODO Auto-generated method stub
		fRepository.deleteById(idFactor);
	}

	@Override
	public Optional<Factor> listId(int idFactor) {
		// TODO Auto-generated method stub
		return fRepository.findById(idFactor);
	}

	@Override
	public void update(Factor factor) {
		// TODO Auto-generated method stub
		fRepository.save(factor);
		
	}





	

}

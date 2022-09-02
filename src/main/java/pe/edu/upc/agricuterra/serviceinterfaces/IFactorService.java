package pe.edu.upc.agricuterra.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.agricuterra.entities.Factor;

public interface IFactorService {

	public void insert(Factor factor);

	List<Factor> list();
	
	
	public void delete(int idFactor);

	Optional<Factor> listId(int idFactor);

	public void update(Factor factor);
}

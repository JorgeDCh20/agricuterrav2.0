package pe.edu.upc.agricuterra.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.agricuterra.entities.TipoFactor;

public interface ITipoFactorService {

	public void insert(TipoFactor tipofactor);
	
	public List<TipoFactor> list();

	public void delete(int idTipoFactor);

	Optional<TipoFactor> listId(int idTipoFactor);

	public void update(TipoFactor tipofactor);

}

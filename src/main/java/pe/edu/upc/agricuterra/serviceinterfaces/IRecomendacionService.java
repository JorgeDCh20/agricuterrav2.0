package pe.edu.upc.agricuterra.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.agricuterra.entities.Recomendacion;

public interface IRecomendacionService {

	public void insert(Recomendacion recomendacion);

	public List<Recomendacion> list();
	public void delete(int idRecomendacion);
	Optional<Recomendacion> listId (int idRecomendacion);
	public void update(Recomendacion recomendacion);
}

package pe.edu.upc.agricuterra.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.agricuterra.entities.TipoRecomendacion;

public interface ITipoRecomendacionService {
	public void insert(TipoRecomendacion tipo);
	
	public List<TipoRecomendacion> list();
	
	public void delete(int idTipo);
	
	Optional<TipoRecomendacion> listId(int idTipo);
	public void update(TipoRecomendacion tipo);
}

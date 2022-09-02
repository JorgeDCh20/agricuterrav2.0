package pe.edu.upc.agricuterra.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.agricuterra.entities.Analisis;

public interface IAnalisisService {

	public void insert(Analisis analisis);

	public List<Analisis> list();

	public void delete(int idAnalisis);
	
	Optional<Analisis> listId(int idAnalisis);
	
	public void update(Analisis analisis);
}

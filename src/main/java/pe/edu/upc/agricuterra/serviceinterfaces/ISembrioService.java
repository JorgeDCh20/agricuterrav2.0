package pe.edu.upc.agricuterra.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.agricuterra.entities.Sembrio;

public interface ISembrioService {

	public void insert(Sembrio sembrio);
	
	public List<Sembrio> list();
	
	public void delete(int idSembrio);
	
	Optional<Sembrio> ListId( int idSembrio);
	
	public void update(Sembrio sembrio);
}

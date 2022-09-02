package pe.edu.upc.agricuterra.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.agricuterra.entities.Proyeccion;

public interface IProyeccionService {

	public void insert(Proyeccion proyeccion);

	public List<Proyeccion> list();

	public void delete(int idProyeccion);

	Optional<Proyeccion> listId(int idProyeccion);

	public void update(Proyeccion proyeccion);

}

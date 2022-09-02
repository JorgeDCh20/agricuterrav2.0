package pe.edu.upc.agricuterra.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.agricuterra.entities.Categoria;
import pe.edu.upc.agricuterra.repositories.ICategoriaRepository;
import pe.edu.upc.agricuterra.serviceinterfaces.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService {
	@Autowired 
	private ICategoriaRepository categoriaRepository;

	@Override
	public void insert(Categoria categoria) {
		categoriaRepository.save(categoria);

	}

	@Override
	public List<Categoria> list() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	@Override
	public void delete(int idCategoria) {
		// TODO Auto-generated method stub
		categoriaRepository.deleteById(idCategoria);
	}

	@Override
	public Optional<Categoria> listId(int idCategoria) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(idCategoria);
	}

	@Override
	public void update(Categoria categoria) {
		// TODO Auto-generated method stub
		categoriaRepository.save(categoria);
	}

}

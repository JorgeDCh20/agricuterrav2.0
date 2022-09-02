package pe.edu.upc.agricuterra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.agricuterra.entities.TipoRecomendacion;

@Repository
public interface ITipoRecomendacionRepository extends JpaRepository<TipoRecomendacion, Integer>{
	
}

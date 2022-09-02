package pe.edu.upc.agricuterra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.agricuterra.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	public Usuario findByNombreUsuario(String nombreUsuario);

}

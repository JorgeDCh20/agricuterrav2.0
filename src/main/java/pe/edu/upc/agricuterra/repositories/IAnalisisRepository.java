package pe.edu.upc.agricuterra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.agricuterra.entities.Analisis;


@Repository
public interface IAnalisisRepository extends JpaRepository<Analisis, Integer> {

}

package pe.edu.upc.agricuterra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.agricuterra.entities.Analisis;


@Repository
public interface IReporteRepository extends JpaRepository<Analisis, Integer> {
	
	@Query(value="Select u.full_name_usuario,s.nombre_sembrio,p.texto_detalles_proyeccion,\r\n"
			+ "a.text_analisis,f.nombre_factor, to_char(p.date_futura_proyeccion, 'dd/MM/yyyy')\r\n"
			+ "from proyeccion p join analisis a \r\n"
			+ "on a.id_analisis=p.id_analisis join sembrio s on s.id_sembrio=a.id_sembrio join factor f on a.id_factor=f.id_factor join usuario u on \r\n"
			+ "u.id_usuario=f.id_usuario\r\n"
			+ "where p.date_futura_proyeccion>NOW() and p.texto_detalles_proyeccion like 'Pésima cosecha'", nativeQuery=true)
	public List<String[]> proyeccionXpesimaCos();
	
	@Query(value="\r\n"
			+ "Select  p.texto_detalles_proyeccion, count(p.id_proyeccion) from proyeccion p\r\n"
			+ "where p.date_futura_proyeccion>NOW()\r\n"
			+ "group by p.texto_detalles_proyeccion order by count(p.id_proyeccion) desc", nativeQuery=true)
	public List<String[]> proyeccionXnombrePro();
	
	@Query(value="Select  s.nombre_sembrio,count(s.id_sembrio) as numero_analisis from sembrio s join analisis a \r\n"
			+ "on s.id_sembrio= a.id_sembrio\r\n"
			+ "group by s.nombre_sembrio \r\n"
			+ "order by count(s.id_sembrio) desc", nativeQuery=true)
	public List<String[]> analisisXsembrio();
	
	@Query(value="select  avg(f.q_precipitacion) as promedio_precipitacion, avg(o.q_humedad) as promedio_humedad, avg(j.q_temperatura) as promedio_temperatura\r\n"
			+ "from factor f, factor o , factor j   \r\n"
			+ "where f.q_precipitacion!=0 and o.q_humedad!=0 and j.q_temperatura!=0", nativeQuery=true)
	public List<String[]> promFactoresAmbientales();
	
	@Query(value="select  avg(f.q_fosfato) as promedio_fosfato, avg(o.q_nitrato) as promedio_nitrato, avg(j.qph) as promedio_Ph, avg(d.q_sulfato) as promedio_sulfato\r\n"
			+ "from factor f, factor o,factor j, factor d\r\n"
			+ "where f.q_fosfato!=0 or o.q_nitrato!=0 and j.qph!=0 and d.q_sulfato!=0", nativeQuery=true)
	public List<String[]> promFactoresMinerales();
}

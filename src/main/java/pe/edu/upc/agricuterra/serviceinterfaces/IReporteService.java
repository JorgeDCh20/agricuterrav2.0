package pe.edu.upc.agricuterra.serviceinterfaces;

import java.util.List;

public interface IReporteService {

	public List<String[]> proyeccionXpesimaCos();
	public List<String[]> proyeccionXnombrePro();
	public List<String[]> analisisXsembrio();
	public List<String[]> promFactoresAmbientales();
	public List<String[]> promFactoresMinerales();

}

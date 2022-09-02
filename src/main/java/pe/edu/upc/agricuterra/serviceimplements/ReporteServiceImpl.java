package pe.edu.upc.agricuterra.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.agricuterra.repositories.IReporteRepository;
import pe.edu.upc.agricuterra.serviceinterfaces.IReporteService;

@Service
public class ReporteServiceImpl implements IReporteService {

	@Autowired
	private IReporteRepository reporteRepository;

	@Override
	public List<String[]> proyeccionXpesimaCos() {
		// TODO Auto-generated method stub
		return reporteRepository.proyeccionXpesimaCos();
	}

	@Override
	public List<String[]> proyeccionXnombrePro() {
		// TODO Auto-generated method stub
		return reporteRepository.proyeccionXnombrePro();
	}

	@Override
	public List<String[]> analisisXsembrio() {
		return reporteRepository.analisisXsembrio();
	}

	@Override
	public List<String[]> promFactoresAmbientales() {
		// TODO Auto-generated method stub
		return reporteRepository.promFactoresAmbientales();
	}

	@Override
	public List<String[]> promFactoresMinerales() {
		// TODO Auto-generated method stub
		return reporteRepository.promFactoresMinerales();
	}
		

}

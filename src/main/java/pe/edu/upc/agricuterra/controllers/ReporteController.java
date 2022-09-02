package pe.edu.upc.agricuterra.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.agricuterra.serviceinterfaces.IReporteService;

@Controller
@RequestMapping("/preportes")
public class ReporteController {

	@Autowired
	private IReporteService reporteService;

	@RequestMapping("/reporte1")
	public String analisisXsembrio(Map<String, Object> model) {
		model.put("listAnalisisSembrio", reporteService.analisisXsembrio());

		return "reportes/report1";
	}

	@RequestMapping("/reporte2")
	public String proyeccionXpesimaCos(Map<String, Object> model) {
		model.put("listProyeccionXpesimaCos", reporteService.proyeccionXpesimaCos());

		return "reportes/report2";
	}

	@RequestMapping("/reporte3")
	public String proyeccionXnombrePro(Map<String, Object> model) {
		model.put("listProyeccionXnombrePro", reporteService.proyeccionXnombrePro());

		return "reportes/report3";
	}

	@RequestMapping("/reporte4")
	public String promFactoresAmbientales(Map<String, Object> model) {
		model.put("listPromFactoresAmbientales", reporteService.promFactoresAmbientales());

		return "reportes/report4";
	}

	@RequestMapping("/reporte5")
	public String promFactoresMinerales(Map<String, Object> model) {
		model.put("listPromFactoresMinerales", reporteService.promFactoresMinerales());

		return "reportes/report5";
	}
}

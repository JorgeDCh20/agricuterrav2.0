package pe.edu.upc.agricuterra.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Factor")
public class Factor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFactor;

	@Column(name = "qPrecipitacion", nullable = true)
	private double qPrecipitacion;
	
	@Column(name = "qHumedad", nullable = true)
	private double qHumedad;
	
	@Column(name = "qTemperatura", nullable = true)
	private double qTemperatura;
	
	@Column(name = "qFosfato", nullable = true)
	private double qFosfato;
	
	@Column(name = "qNitrato", nullable = true)
	private double qNitrato;
	
	@Column(name = "qSulfato", nullable = true)
	private double qSulfato;
	
	@Column(name = "qPH", nullable = true)
	private double qPH;
	
	@Column(name = "nombreFactor")
	private String nombreFactor;

	@ManyToOne
	@JoinColumn(name = "idTipoFactor")
	private TipoFactor tipofactor;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	public Factor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factor(int idFactor, double qPrecipitacion, double qHumedad, double qTemperatura, double qFosfato,
			double qNitrato, double qSulfato, double qPH, String nombreFactor, TipoFactor tipofactor, Usuario usuario) {
		super();
		this.idFactor = idFactor;
		this.qPrecipitacion = qPrecipitacion;
		this.qHumedad = qHumedad;
		this.qTemperatura = qTemperatura;
		this.qFosfato = qFosfato;
		this.qNitrato = qNitrato;
		this.qSulfato = qSulfato;
		this.qPH = qPH;
		this.nombreFactor = nombreFactor;
		this.tipofactor = tipofactor;
		this.usuario = usuario;
	}

	public int getIdFactor() {
		return idFactor;
	}

	public void setIdFactor(int idFactor) {
		this.idFactor = idFactor;
	}

	public double getqPrecipitacion() {
		return qPrecipitacion;
	}

	public void setqPrecipitacion(double qPrecipitacion) {
		this.qPrecipitacion = qPrecipitacion;
	}

	public double getqHumedad() {
		return qHumedad;
	}

	public void setqHumedad(double qHumedad) {
		this.qHumedad = qHumedad;
	}

	public double getqTemperatura() {
		return qTemperatura;
	}

	public void setqTemperatura(double qTemperatura) {
		this.qTemperatura = qTemperatura;
	}

	public double getqFosfato() {
		return qFosfato;
	}

	public void setqFosfato(double qFosfato) {
		this.qFosfato = qFosfato;
	}

	public double getqNitrato() {
		return qNitrato;
	}

	public void setqNitrato(double qNitrato) {
		this.qNitrato = qNitrato;
	}

	public double getqSulfato() {
		return qSulfato;
	}

	public void setqSulfato(double qSulfato) {
		this.qSulfato = qSulfato;
	}

	public double getqPH() {
		return qPH;
	}

	public void setqPH(double qPH) {
		this.qPH = qPH;
	}

	public String getNombreFactor() {
		return nombreFactor;
	}

	public void setNombreFactor(String nombreFactor) {
		this.nombreFactor = nombreFactor;
	}

	public TipoFactor getTipofactor() {
		return tipofactor;
	}

	public void setTipofactor(TipoFactor tipofactor) {
		this.tipofactor = tipofactor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	

}

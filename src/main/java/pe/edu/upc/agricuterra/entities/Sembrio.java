package pe.edu.upc.agricuterra.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sembrio")
public class Sembrio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSembrio;
	
	@Column(name="nombreSembrio", length=48,nullable=false)
	private String nombreSembrio;
	
	@Column(name="temperaturaIdeal", length=35,nullable=false)
	private double temperaturaIdeal;
	
	@Column(name="phIdeal", length=8,nullable=false)
	private double phIdeal;
	
	@Column(name="humedadIdeal", length=35,nullable=false)
	private double humedadIdeal;

	
	
	public Sembrio() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Sembrio(int idSembrio, String nombreSembrio, double temperaturaIdeal, double phIdeal, double humedadIdeal) {
		super();
		this.idSembrio = idSembrio;
		this.nombreSembrio = nombreSembrio;
		this.temperaturaIdeal = temperaturaIdeal;
		this.phIdeal = phIdeal;
		this.humedadIdeal = humedadIdeal;
	}



	public int getIdSembrio() {
		return idSembrio;
	}



	public void setIdSembrio(int idSembrio) {
		this.idSembrio = idSembrio;
	}



	public String getNombreSembrio() {
		return nombreSembrio;
	}



	public void setNombreSembrio(String nombreSembrio) {
		this.nombreSembrio = nombreSembrio;
	}



	public double getTemperaturaIdeal() {
		return temperaturaIdeal;
	}



	public void setTemperaturaIdeal(double temperaturaIdeal) {
		this.temperaturaIdeal = temperaturaIdeal;
	}



	public double getPhIdeal() {
		return phIdeal;
	}



	public void setPhIdeal(double phIdeal) {
		this.phIdeal = phIdeal;
	}



	public double getHumedadIdeal() {
		return humedadIdeal;
	}



	public void setHumedadIdeal(double humedadIdeal) {
		this.humedadIdeal = humedadIdeal;
	}
	
	
	
	
}

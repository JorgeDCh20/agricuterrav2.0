package pe.edu.upc.agricuterra.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TipoRecomendacion")
public class TipoRecomendacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTipoRecomendacion;
	
	@Column(name="nameTipoRecomendacion", length=48, nullable=false)
	private String nameTipoRecomendacion;
	
		
	public TipoRecomendacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TipoRecomendacion(int idTipoRecomendacion, String nameTipoRecomendacion) {
		super();
		this.idTipoRecomendacion = idTipoRecomendacion;
		this.nameTipoRecomendacion = nameTipoRecomendacion;
	}


	public int getIdTipoRecomendacion() {
		return idTipoRecomendacion;
	}


	public void setIdTipoRecomendacion(int idTipoRecomendacion) {
		this.idTipoRecomendacion = idTipoRecomendacion;
	}


	public String getNameTipoRecomendacion() {
		return nameTipoRecomendacion;
	}


	public void setNameTipoRecomendacion(String nameTipoRecomendacion) {
		this.nameTipoRecomendacion = nameTipoRecomendacion;
	}


			
	
}

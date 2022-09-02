package pe.edu.upc.agricuterra.entities;
///http://localhost:8082/ccategorias/new
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Recomendacion")
public class Recomendacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRecomendacion;
	
	@ManyToOne
	@JoinColumn(name = "idTipoRecomendacion",nullable = false)
	private TipoRecomendacion tipoRecomendacion;

	@Column(name = "descripcionRecomendacion", length = 70, nullable = false)
	private String descripcionRecomendacion;

	public Recomendacion(int idRecomendacion, TipoRecomendacion tipoRecomendacion, String descripcionRecomendacion) {
		super();
		this.idRecomendacion = idRecomendacion;
		this.tipoRecomendacion = tipoRecomendacion;
		this.descripcionRecomendacion = descripcionRecomendacion;
	}

	public Recomendacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdRecomendacion() {
		return idRecomendacion;
	}

	public void setIdRecomendacion(int idRecomendacion) {
		this.idRecomendacion = idRecomendacion;
	}

	public TipoRecomendacion getTipoRecomendacion() {
		return tipoRecomendacion;
	}

	public void setTipoRecomendacion(TipoRecomendacion tipoRecomendacion) {
		this.tipoRecomendacion = tipoRecomendacion;
	}

	public String getDescripcionRecomendacion() {
		return descripcionRecomendacion;
	}

	public void setDescripcionRecomendacion(String descripcionRecomendacion) {
		this.descripcionRecomendacion = descripcionRecomendacion;
	}

	




}

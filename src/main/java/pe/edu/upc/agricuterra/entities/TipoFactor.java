package pe.edu.upc.agricuterra.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoFactor")
public class TipoFactor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoFactor;
	
	@Column(name="NombreTipoFactor", length= 25, nullable = false )
	private String NombreTipoFactor;

	public TipoFactor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoFactor(int idTipoFactor, String nombreTipoFactor) {
		super();
		this.idTipoFactor = idTipoFactor;
		this.NombreTipoFactor = nombreTipoFactor;
	}

	public int getIdTipoFactor() {
		return idTipoFactor;
	}

	public void setIdTipoFactor(int idTipoFactor) {
		this.idTipoFactor = idTipoFactor;
	}

	public String getNombreTipoFactor() {
		return NombreTipoFactor;
	}

	public void setNombreTipoFactor(String nombreTipoFactor) {
		this.NombreTipoFactor = nombreTipoFactor;
	}

	
	
}

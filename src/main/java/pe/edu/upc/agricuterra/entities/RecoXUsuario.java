package pe.edu.upc.agricuterra.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RecoXUsuario")
public class RecoXUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRecoXUsuario;

	@ManyToOne
	@JoinColumn(name = "idRecomendacion", nullable =false)
	private Recomendacion recomendacion;

	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable =false)
	private Usuario usuario;
	
	
	public RecoXUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public RecoXUsuario(int idRecoXUsuario, Recomendacion recomendacion, Usuario usuario) {
		super();
		this.idRecoXUsuario = idRecoXUsuario;
		this.recomendacion = recomendacion;
		this.usuario = usuario;
	}
	

	public int getIdRecoXUsuario() {
		return idRecoXUsuario;
	}

	public void setIdRecoXUsuario(int idRecoXUsuario) {
		this.idRecoXUsuario = idRecoXUsuario;
	}

	public Recomendacion getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(Recomendacion recomendacion) {
		this.recomendacion = recomendacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}

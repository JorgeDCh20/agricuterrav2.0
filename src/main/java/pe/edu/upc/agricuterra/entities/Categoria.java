package pe.edu.upc.agricuterra.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idCategoria;

	@Column(name = "nameCategoria", length = 48, nullable = false)
	private String nameCategoria;

	public Categoria(int idCategoria, String nameCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nameCategoria = nameCategoria;
	}

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNameCategoria() {
		return nameCategoria;
	}

	public void setNameCategoria(String nameCategoria) {
		this.nameCategoria = nameCategoria;
	}


}

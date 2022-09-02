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
@Table(name="Analisis")
public class Analisis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAnalisis;
	
	@Column( name="TextAnalisis", length = 100, nullable=false)
	private String TextAnalisis;
	
	
	@ManyToOne
	@JoinColumn(name="idSembrio" )
	private Sembrio sembrio;
	
	@ManyToOne
	@JoinColumn(name="idFactor" )
	private Factor factor;

	public Analisis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Analisis(int idAnalisis, String textAnalisis, Sembrio sembrio, Factor factor) {
		super();
		this.idAnalisis = idAnalisis;
		TextAnalisis = textAnalisis;
		this.sembrio = sembrio;
		this.factor = factor;
	}

	public int getIdAnalisis() {
		return idAnalisis;
	}

	public void setIdAnalisis(int idAnalisis) {
		this.idAnalisis = idAnalisis;
	}

	public String getTextAnalisis() {
		return TextAnalisis;
	}

	public void setTextAnalisis(String textAnalisis) {
		TextAnalisis = textAnalisis;
	}

	public Sembrio getSembrio() {
		return sembrio;
	}

	public void setSembrio(Sembrio sembrio) {
		this.sembrio = sembrio;
	}

	public Factor getFactor() {
		return factor;
	}

	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	
	
	
}

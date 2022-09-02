package pe.edu.upc.agricuterra.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idUsuario;
	@ManyToOne
	@JoinColumn(name = "idCategoria", nullable = false)
	private Categoria categoria;

	@Column(name = "fullNameUsuario", nullable = false, length = 47)
	private String fullNameUsuario;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birthDateUsuario", nullable = false)
	private Date birthDateUsuario;

	@Column(name = "specialtyUsuario", nullable = false, length = 46)
	private String specialtyUsuario;

	@Column(name = "companyUsuario", nullable = true, length = 45)
	private String companyUsuario;

	@Column(name = "emailUsuario", nullable = true, length = 45)
	private String emailUsuario;

	@Column(name = "nombreUsuario", nullable = false, length = 47)
	private String nombreUsuario;

	@Column(name = "passwordUsuario", nullable = false)
	private String passwordUsuario;
	
	private Boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> roles;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int idUsuario, Categoria categoria, String fullNameUsuario, Date birthDateUsuario,
			String specialtyUsuario, String companyUsuario, String emailUsuario, String nombreUsuario,
			String passwordUsuario, Boolean enabled, List<Role> roles) {
		super();
		this.idUsuario = idUsuario;
		this.categoria = categoria;
		this.fullNameUsuario = fullNameUsuario;
		this.birthDateUsuario = birthDateUsuario;
		this.specialtyUsuario = specialtyUsuario;
		this.companyUsuario = companyUsuario;
		this.emailUsuario = emailUsuario;
		this.nombreUsuario = nombreUsuario;
		this.passwordUsuario = passwordUsuario;
		this.enabled = enabled;
		this.roles = roles;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getFullNameUsuario() {
		return fullNameUsuario;
	}

	public void setFullNameUsuario(String fullNameUsuario) {
		this.fullNameUsuario = fullNameUsuario;
	}

	public Date getBirthDateUsuario() {
		return birthDateUsuario;
	}

	public void setBirthDateUsuario(Date birthDateUsuario) {
		this.birthDateUsuario = birthDateUsuario;
	}

	public String getSpecialtyUsuario() {
		return specialtyUsuario;
	}

	public void setSpecialtyUsuario(String specialtyUsuario) {
		this.specialtyUsuario = specialtyUsuario;
	}

	public String getCompanyUsuario() {
		return companyUsuario;
	}

	public void setCompanyUsuario(String companyUsuario) {
		this.companyUsuario = companyUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

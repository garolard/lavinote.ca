package es.gabrielferreiro.apps.lavinoteca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Cliente implements Serializable {
	private static final long serialVersionUID = -4963933852561530126L;

	private Integer id;
	private String correo;
	private String contrasenha;
	private String nombre;
	private String apellido;
	private String direccion;
	private String dni;
	private Date fechaNacimiento;
	private String tfnoFijo;
	private String tfnoPrincipal;
	private Integer codigoPostal;
	private List<Pedido> historialCompras;
	
	public Cliente(){}
	
	public Cliente(String correo, String contrasenha, String nombre,
			String apellido, String direccion) {
		this(correo, contrasenha, nombre, apellido, direccion, null, null, null, null, null, null);
	}

	public Cliente(String correo, String contrasenha, String nombre,
			String apellido, String direccion, String dni,
			Date fechaNacimiento, String tfnoFijo, String tfnoPrincipal,
			Integer codigoPostal, List<Pedido> historialCompras) {
		super();
		this.correo = correo;
		this.contrasenha = contrasenha;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.tfnoFijo = tfnoFijo;
		this.tfnoPrincipal = tfnoPrincipal;
		this.codigoPostal = codigoPostal;
		this.historialCompras = historialCompras;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTfnoFijo() {
		return tfnoFijo;
	}

	public void setTfnoFijo(String tfnoFijo) {
		this.tfnoFijo = tfnoFijo;
	}

	public String getTfnoPrincipal() {
		return tfnoPrincipal;
	}

	public void setTfnoPrincipal(String tfnoPrincipal) {
		this.tfnoPrincipal = tfnoPrincipal;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public List<Pedido> getHistorialCompras() {
		return historialCompras;
	}

	public void setHistorialCompras(List<Pedido> historialCompras) {
		this.historialCompras = historialCompras;
	}
	
}

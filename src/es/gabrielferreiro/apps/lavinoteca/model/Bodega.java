package es.gabrielferreiro.apps.lavinoteca.model;

import java.io.Serializable;
import java.util.List;

public class Bodega implements Serializable {
	private static final long serialVersionUID = -5779536672596899060L;

	private Integer id;
	private String nombre;
	private String codigoSesion;
	private String claveSesion;
	private List<Vino> vinos;
	
	public Bodega(String nombre, String codigoSesion, String claveSesion) {
		this(nombre, codigoSesion, claveSesion, null);
	}

	public Bodega(String nombre, String codigoSesion, String claveSesion,
			List<Vino> vinos) {
		super();
		this.nombre = nombre;
		this.codigoSesion = codigoSesion;
		this.claveSesion = claveSesion;
		this.vinos = vinos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoSesion() {
		return codigoSesion;
	}

	public void setCodigoSesion(String codigoSesion) {
		this.codigoSesion = codigoSesion;
	}

	public String getClaveSesion() {
		return claveSesion;
	}

	public void setClaveSesion(String claveSesion) {
		this.claveSesion = claveSesion;
	}

	public List<Vino> getVinos() {
		return vinos;
	}

	public void setVinos(List<Vino> vinos) {
		this.vinos = vinos;
	}
	
}

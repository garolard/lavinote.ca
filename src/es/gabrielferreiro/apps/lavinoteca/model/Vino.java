package es.gabrielferreiro.apps.lavinoteca.model;

import java.io.Serializable;

public class Vino implements Serializable {
	private static final long serialVersionUID = -8353064160680635042L;

	private Integer id;
	private String nombre;
	private VinoCategoria categoria;
	private Bodega bodega;
	private String elaboracion;
	private Integer cosecha;
	private String rutaImagen;
	
	public Vino() {}
	
	public Vino(String nombre, VinoCategoria categoria, Bodega bodega, String rutaImagen) {
		this(nombre, categoria, bodega, rutaImagen, null, null);
	}

	public Vino(String nombre, VinoCategoria categoria, Bodega bodega,
			String rutaImagen, String elaboracion, Integer cosecha) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.bodega = bodega;
		this.setRutaImagen(rutaImagen);
		this.elaboracion = elaboracion;
		this.cosecha = cosecha;
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

	public VinoCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(VinoCategoria categoria) {
		this.categoria = categoria;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public String getElaboracion() {
		return elaboracion;
	}

	public void setElaboracion(String elaboracion) {
		this.elaboracion = elaboracion;
	}

	public Integer getCosecha() {
		return cosecha;
	}

	public void setCosecha(Integer cosecha) {
		this.cosecha = cosecha;
	}
	
}

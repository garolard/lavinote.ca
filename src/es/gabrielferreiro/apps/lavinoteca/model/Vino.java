package es.gabrielferreiro.apps.lavinoteca.model;

import java.io.Serializable;
import java.util.Date;

public class Vino implements Serializable {
	private static final long serialVersionUID = -8353064160680635042L;

	private Integer id;
	private String nombre;
	private VinoCategoria categoria;
	private Bodega bodega;
	private String elaboracion;
	private Date cosecha;
	private String rutaImagen;
	private Float precioUnitario;
	
	public Vino() {}
	
	public Vino(String nombre, VinoCategoria categoria, Bodega bodega, Float precioUnitario, String rutaImagen) {
		this(nombre, categoria, bodega, rutaImagen, null, null, precioUnitario);
	}

	public Vino(String nombre, VinoCategoria categoria, Bodega bodega,
			String rutaImagen, String elaboracion, Date cosecha, Float precioUnitario) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.bodega = bodega;
		this.setRutaImagen(rutaImagen);
		this.elaboracion = elaboracion;
		this.cosecha = cosecha;
		this.setPrecioUnitario(precioUnitario);
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

	public Date getCosecha() {
		return cosecha;
	}

	public void setCosecha(Date cosecha) {
		this.cosecha = cosecha;
	}

	public Float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vino other = (Vino) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

package es.gabrielferreiro.apps.lavinoteca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Pedido implements Serializable {
	private static final long serialVersionUID = -7795231279052963484L;

	private Integer id;
	private Date fecha;
	private EstadoPedido estado;
	private Cliente cliente;
	private List<Vino> productos;
	
	public Pedido(Date fecha, EstadoPedido estado, Cliente cliente,
			List<Vino> productos) {
		super();
		this.fecha = fecha;
		this.estado = estado;
		this.cliente = cliente;
		this.productos = productos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Vino> getProductos() {
		return productos;
	}

	public void setProductos(List<Vino> productos) {
		this.productos = productos;
	}
	
}

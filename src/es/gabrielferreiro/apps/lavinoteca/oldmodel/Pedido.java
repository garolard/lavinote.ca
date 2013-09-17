package es.gabrielferreiro.apps.lavinoteca.oldmodel;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import es.gabrielferreiro.apps.lavinoteca.model.Cliente;
import es.gabrielferreiro.apps.lavinoteca.model.LineaPedido;

public class Pedido implements Serializable {
	private static final long serialVersionUID = -7795231279052963484L;

	private Integer id;
	private Date fecha;
	private EstadoPedido estado;
	private Cliente cliente;
	private List<LineaPedido> lineas;
	
	public Pedido(Date fecha, EstadoPedido estado, Cliente cliente,
			List<LineaPedido> lineas) {
		super();
		this.fecha = fecha;
		this.estado = estado;
		this.cliente = cliente;
		this.lineas = lineas;
	}
	
	public Pedido(Date fecha, EstadoPedido estado, Cliente cliente) {
		this(fecha, estado, cliente, null);
		this.lineas = new LinkedList<>();
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

	public List<LineaPedido> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaPedido> lineas) {
		this.lineas = lineas;
	}
	
}

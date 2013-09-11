package es.gabrielferreiro.apps.lavinoteca.model;

import java.io.Serializable;

public class LineaPedido implements Serializable {
	private static final long serialVersionUID = 1977553636075394902L;

	private Integer id;
	private Vino vino;
	private Pedido pedido;
	private Integer cantidad;
	
	public LineaPedido(Vino vino, Pedido pedido, Integer cantidad) {
		super();
		this.vino = vino;
		this.pedido = pedido;
		this.cantidad = cantidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Vino getVino() {
		return vino;
	}

	public void setVino(Vino vino) {
		this.vino = vino;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}

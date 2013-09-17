package es.gabrielferreiro.apps.lavinoteca.service;

import es.gabrielferreiro.apps.lavinoteca.model.Cliente;
import es.gabrielferreiro.apps.lavinoteca.model.Pedido;

public interface ICarritoService {
	public Pedido obtenerPedido(Integer pedidoId);
	public void agregarPedido(Pedido pedido);
	public void confirmarPago(Integer pedidoId);
	public void cancelarPedido(Integer pedidoId);
}

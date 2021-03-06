package es.gabrielferreiro.apps.lavinoteca.dao;

import es.gabrielferreiro.apps.lavinoteca.model.Cliente;

public interface IClienteDao extends IDao<Cliente, Integer> {
	public Cliente autenticar(String correo, String contrasenha);
}

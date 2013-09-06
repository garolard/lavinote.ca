package es.gabrielferreiro.apps.lavinoteca.service;

public abstract class VinoServiceFactory {
	public static VinoService createVinoService() {
		return new VinoService();
	}
}

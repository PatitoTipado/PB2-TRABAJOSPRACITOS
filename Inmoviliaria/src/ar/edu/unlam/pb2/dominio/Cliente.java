package ar.edu.unlam.pb2.dominio;

import java.util.List;
import java.util.ArrayList;

public class Cliente {

	private List<Propiedad> propiedades = new ArrayList<Propiedad>();
	private Integer saldo = 0;

	public void agregarPropiedad(Propiedad buscarPorCodigoPropiedad) {
		propiedades.add(buscarPorCodigoPropiedad);
	}

	public List<Propiedad> getPropiedades() {
		return this.propiedades;
	}

	public void cobrarPropiedad(Integer valor) {
		saldo += valor;
	}

	public void restarSaldo(Integer valor) {
		saldo -= valor;
	}

}

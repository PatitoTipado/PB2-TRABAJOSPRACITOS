package ar.edu.unlam.dominio;

import java.util.*;

public class ReproductorDeMusica {

	private LinkedList<Usuario> listaDeUsuarios;

	public ReproductorDeMusica() {
		super();
		this.listaDeUsuarios = new LinkedList<Usuario>();
	}

	public Boolean agregarUnUsuario(Usuario usuario) {

		Boolean agregar = false;

		if (usuario != null) {
			agregar = this.listaDeUsuarios.add(usuario);
		}

		return agregar;
	}

	public Boolean agregarListaDeReproduccion(Usuario usuario, ArrayList<Musica> listaDeReproduccion) {

		boolean sePudoAgregarLista = false;
		Usuario usuarioBuscado = buscar(usuario);

		if (usuarioBuscado != null && usuarioBuscado.agregarListaDeReproduccion(listaDeReproduccion)) {
			sePudoAgregarLista = true;
		}

		return sePudoAgregarLista;

	}

	public boolean agregarCancion(Usuario usuario, Integer indiceDeLista, Musica cancion) {

		boolean sePudoAgregarLista = false;
		Usuario usuarioAux = buscar(usuario);

		if (usuarioAux != null && usuarioAux.agregarCancion(indiceDeLista, cancion)) {
			sePudoAgregarLista = true;
		}

		return sePudoAgregarLista;
	}

	public String listadoDeCanciones(Usuario usuario, Integer indice) {

		String listadoDeCanciones = "";
		Usuario usuarioBuscado = buscar(usuario);

		if (usuarioBuscado != null) {

			for (int i = 0; i < usuarioBuscado.getListasDeReproduccion(indice).size(); i++) {
				if (usuarioBuscado.getListasDeReproduccion(indice).get(i) != null) {
					listadoDeCanciones += usuarioBuscado.getListasDeReproduccion(indice).get(i).toString() + " ";
				}
			}

		}

		return listadoDeCanciones;
	}

	public Integer listadoDeCantidadDeCanciones(Usuario usuario, Integer indice) {

		Integer cantidadDeCanciones = 0;
		Usuario usuarioBuscado = buscar(usuario);

		if (usuarioBuscado != null) {

			for (int i = 0; i < usuarioBuscado.getListasDeReproduccion(indice).size(); i++) {
				if (usuarioBuscado.getListasDeReproduccion(indice).get(i) != null) {
					cantidadDeCanciones++;
				}
			}

		}

		return cantidadDeCanciones;
	}

	public String duracionDeLaListaDeCanciones(Usuario usuario, Integer indice) {

		Integer DuracionDeListadoDeCanciones = 0;
		Integer horas = 0;
		Integer minutos = 0;
		Usuario usuarioBuscado = buscar(usuario);

		if (usuarioBuscado != null) {

			for (int i = 0; i < usuarioBuscado.getListasDeReproduccion(indice).size(); i++) {
				if (usuarioBuscado.getListasDeReproduccion(indice).get(i) != null) {
					DuracionDeListadoDeCanciones++;
				}
			}

		}

		if (DuracionDeListadoDeCanciones > 0) {

			horas = (int) DuracionDeListadoDeCanciones / 60;
			minutos = (int) DuracionDeListadoDeCanciones % 60;

		}

		return "Tiempo total: " + horas + " horas y " + minutos + " minutos";
	}

	public Integer getCantidadDeCanciones(Usuario usuario, Integer indiceDeLista) {
		Integer contador = 0;
		Usuario buscado = buscar(usuario);

		if (buscado != null) {
			contador = buscado.getCantidadDeCanciones(indiceDeLista);
		}

		return contador;
	}

	public Integer getCantidadDeListasCanciones(Usuario usuario) {
		Integer contador = 0;
		Usuario buscado = buscar(usuario);

		if (buscado != null) {
			contador = buscado.getCantidadDeListasDeReproduccion();
		}

		return contador;
	}

	private Usuario buscar(Usuario usuarioBuscado) {
		Usuario aux = null;

		if (this.listaDeUsuarios.contains(usuarioBuscado)) {
			for (int i = 0; i < this.listaDeUsuarios.size() && aux == null; i++) {
				if (listaDeUsuarios.get(i).equals(usuarioBuscado)) {
					aux = listaDeUsuarios.get(i);
				}
			}

		}

		return aux;
	}
}

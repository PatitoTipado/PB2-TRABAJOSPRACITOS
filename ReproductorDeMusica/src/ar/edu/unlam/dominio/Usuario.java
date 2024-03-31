package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario {

	private String nombre;
	private Integer dni;
	private ArrayList<ArrayList<Musica>> listasDeReproduccion;

	public Usuario(String nombre, Integer dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.listasDeReproduccion = new ArrayList<>();
	}

	public boolean agregarListaDeReproduccion(ArrayList<Musica> listaDeReproduccion) {

		return listasDeReproduccion.add(listaDeReproduccion);
	}

	public boolean agregarCancion(Integer indice, Musica cancion) {

		Boolean agregar = false;

		if (siSePuedeAgregarCancion(indice, cancion)) {

			agregar = this.listasDeReproduccion.get(indice).add(cancion);

		}

		return agregar;
	}

	private boolean siSePuedeAgregarCancion(Integer indice, Musica cancion) {

		return cancion != null && indice <= this.listasDeReproduccion.size() && !existe(cancion.getNombre(), indice);
	}

	private boolean existe(String nombre, Integer indice) {

		Boolean existe = false;

		Musica buscada = new Musica(nombre);

		for (int j = 0; j < listasDeReproduccion.get(indice).size() && !existe; j++) {

			if (this.listasDeReproduccion.get(indice).get(j).equals(buscada)) {

				existe = true;

			}

		}

		return existe;

	}

	public Integer getCantidadDeCanciones(Integer indiceDeLista) {
		Integer contador = 0;

		for (int i = 0; i < this.listasDeReproduccion.get(indiceDeLista).size(); i++) {
			if (this.listasDeReproduccion.get(indiceDeLista).get(i) != null) {
				contador++;
			}
		}

		return contador;
	}

	public Integer getCantidadDeListasDeReproduccion() {
		Integer contador = 0;

		for (int i = 0; i < this.listasDeReproduccion.size(); i++) {
			if (this.listasDeReproduccion.get(i) != null) {
				contador++;
			}
		}

		return contador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public ArrayList<Musica> getListasDeReproduccion(Integer indice) {
		return listasDeReproduccion.get(indice);
	}

}

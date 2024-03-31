package ar.edu.unlam.dominio;

import java.util.Objects;

public class Musica {

	private String nombre;
	private Double duracion;

	public Musica(String nombre) {

		this.duracion = Math.random() * 1000;
		this.nombre = nombre;

	}

	public String getNombre() {
		return nombre;
	}

	public Double getDuracion() {
		return duracion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Musica [nombre=" + nombre + ", duracion=" + duracion + "]";
	}

}

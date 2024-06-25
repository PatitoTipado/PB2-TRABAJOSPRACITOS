package ar.edu.unlam.pb2.practica.dominio;

import java.util.Objects;

public class Juego implements Comparable<Juego> {

	public Integer getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public Integer getCantidadJugadores() {
		return cantidadJugadores;
	}

	public String getCategoria() {
		return categoria;
	}

	public static Integer getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "Juego [titulo=" + titulo + ", consola=" + consola + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(consola, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		return Objects.equals(consola, other.consola) && Objects.equals(titulo, other.titulo);
	}

	private Integer codigo;
	private String titulo;
	private String consola;
	private Integer cantidadJugadores;
	private String categoria;
	private static Integer numero = 0;

	public Juego(String titulo, String consola, Integer cantidadJugadores, String categoria) {
		super();
		this.codigo = numero;
		this.titulo = titulo;
		this.consola = consola;
		this.cantidadJugadores = cantidadJugadores;
		this.categoria = categoria;
		numero++;
	}

	@Override
	public int compareTo(Juego o) {
		int titulo = this.consola.compareTo(o.consola);
		if (titulo != 0) {
			return titulo;
		}

		return this.titulo.compareTo(o.titulo);
	}

	public String getConsola() {
		return this.consola;
	}

}

package ar.edu.unlam.pb2.practica.dominio;

import java.util.*;

public class PlataformaDeJuego {
	
	@Override
	public String toString() {
		return "PlataformaDeJuego [nombre=" + nombre + "]";
	}

	private String nombre;
	private HashSet <Juego> misJuegos;

	public PlataformaDeJuego(String nombre) {

		this.nombre= nombre;
		misJuegos= new HashSet<Juego>();
	
	}

	public void agregarJuego(Juego juego) {
		misJuegos.add(juego);
	}

	public Integer getCantidadDeJuegos() {
		// TODO Auto-generated method stub
		return misJuegos.size();
	}

	public TreeSet<Juego> miBibliotecaDeJuegosNintendo64() {

		TreeSet <Juego> juegos = new TreeSet<Juego>();
		
		for (Juego juego : this.misJuegos) {
			if(juego.getConsola().equals("nintendo64")) {
				juegos.add(juego);
			}
		}
		
		return juegos;
	}
	
	

}

package ar.edu.unlam.pb2.practica.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import ar.edu.unlam.pb2.practica.dominio.Juego;
import ar.edu.unlam.pb2.practica.dominio.PlataformaDeJuego;

public class VideojuegosTest {

	@Test
	public void queSePuedaAlmacenar5Juegos() {

		PlataformaDeJuego biblioteca = new PlataformaDeJuego("steam");
		
		biblioteca.agregarJuego(new Juego("mario","sega",2,"todoPublico"));
		biblioteca.agregarJuego(new Juego("mario","ps2",2,"todoPublico"));
		biblioteca.agregarJuego(new Juego("mario","ps1",2,"todoPublico"));
		biblioteca.agregarJuego(new Juego("mario","ps3",2,"todoPublico"));
		biblioteca.agregarJuego(new Juego("mario","ps4",2,"todoPublico"));

	
		assertTrue(biblioteca.getCantidadDeJuegos().equals(5));
	}
	
	@Test
	public void buscarLosJuegosQueSeanDeNintendo64() {

		PlataformaDeJuego biblioteca = new PlataformaDeJuego("steam");
		
		biblioteca.agregarJuego(new Juego("mario","nintendo64",2,"todoPublico"));
		biblioteca.agregarJuego(new Juego("black","nintendo64",2,"todoPublico"));
		biblioteca.agregarJuego(new Juego("marioCars","ps1",2,"todoPublico"));
		biblioteca.agregarJuego(new Juego("mario","ps3",2,"todoPublico"));
		biblioteca.agregarJuego(new Juego("mario","ps4",2,"todoPublico"));

		Set <Juego>juegosEsperados = new TreeSet <Juego>(); 
		
		juegosEsperados.add(new Juego("mario","nintendo64",2,"todoPublico"));
		juegosEsperados.add(new Juego("black","nintendo64",2,"todoPublico"));
	
		assertEquals(juegosEsperados,biblioteca.miBibliotecaDeJuegosNintendo64());
	}

}

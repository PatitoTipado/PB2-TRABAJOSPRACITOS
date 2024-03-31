package ar.edu.unlam.test;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

import ar.edu.unlam.dominio.Musica;
import ar.edu.unlam.dominio.Usuario;

public class TestingUsuario {

	@Test
	public void sePuedeAgregarListasDeReproduccion() {

		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		ArrayList<Musica> lista = new ArrayList<Musica>();

		// ejecucion
		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);

		// test

		assertTrue(usuario.agregarListaDeReproduccion(lista));
	}

	@Test
	public void sePuedeAgregarCanciones() {

		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		String nombreDeCancion = "Crysis";
		ArrayList<Musica> lista = new ArrayList<Musica>();

		// ejecucion

		Musica cancionAgregar = new Musica(nombreDeCancion);
		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		usuario.agregarListaDeReproduccion(lista);

		// test

		assertTrue(usuario.agregarCancion(0, cancionAgregar));
	}

	@Test
	public void queNoSePuedaAgregarCancionesNull() {

		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		ArrayList<Musica> lista = new ArrayList<Musica>();

		// ejecucion
		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		usuario.agregarListaDeReproduccion(lista);

		// test

		assertFalse(usuario.agregarCancion(0, null));
	}

	@Test
	public void queNoSePuedaAgregarCancionesSiElIndiceDeLaListaNoExiste() {

		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		String nombreDeCancion = "Crysis";
		ArrayList<Musica> lista = new ArrayList<Musica>();

		// ejecucion

		Musica cancionAgregar = new Musica(nombreDeCancion);
		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		usuario.agregarListaDeReproduccion(lista);

		// test

		assertFalse(usuario.agregarCancion(5, cancionAgregar));
	}

	@Test
	public void queNoSePuedaAgregarCancionesConElMismoNombre() {

		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		String nombreDeCancion = "Crysis";
		ArrayList<Musica> lista = new ArrayList<Musica>();

		// ejecucion

		Musica cancionAgregar = new Musica(nombreDeCancion);
		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		usuario.agregarListaDeReproduccion(lista);
		usuario.agregarCancion(0, cancionAgregar);

		// test

		assertFalse(usuario.agregarCancion(0, cancionAgregar));
	}

	@Test
	public void queSePuedaAgregarCancionesConDiferenteNombre() {

		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		String nombreDeCancion = "Crysis", nombre2 = "pepe";
		ArrayList<Musica> lista = new ArrayList<Musica>();

		// ejecucion

		Musica cancionAgregar = new Musica(nombreDeCancion);
		Musica cancionAgregar1 = new Musica(nombre2);
		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		usuario.agregarListaDeReproduccion(lista);
		usuario.agregarCancion(0, cancionAgregar);

		// test

		assertTrue(usuario.agregarCancion(0, cancionAgregar1));
	}

	@Test
	public void queSePuedaObtenerLaCantidadDeCanciones() {

		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		String nombreDeCancion = "Crysis", nombre2 = "pepe";
		ArrayList<Musica> lista = new ArrayList<Musica>();
		Integer valorEsperado = 2;

		// ejecucion

		Musica cancionAgregar = new Musica(nombreDeCancion);
		Musica cancionAgregar1 = new Musica(nombre2);
		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		usuario.agregarListaDeReproduccion(lista);
		usuario.agregarCancion(0, cancionAgregar);
		usuario.agregarCancion(0, cancionAgregar1);

		// test

		assertEquals(valorEsperado, usuario.getCantidadDeCanciones(0));
	}

	@Test
	public void queSePuedaObtenerLaCantidadDeCancionesCuandoSonCero() {

		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		ArrayList<Musica> lista = new ArrayList<Musica>();
		Integer valorEsperado = 0;

		// ejecucion

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		usuario.agregarListaDeReproduccion(lista);

		// test

		assertEquals(valorEsperado, usuario.getCantidadDeCanciones(0));
	}

	@Test
	public void queSePuedaObtenerLaCantidadDeListasCanciones() {

		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		String nombreDeCancion = "Crysis", nombre2 = "pepe";
		ArrayList<Musica> lista = new ArrayList<Musica>(), lista2 = new ArrayList<Musica>();
		Integer valorEsperado = 3;

		// ejecucion

		Musica cancionAgregar = new Musica(nombreDeCancion);
		Musica cancionAgregar1 = new Musica(nombre2);
		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		usuario.agregarListaDeReproduccion(lista);
		usuario.agregarCancion(0, cancionAgregar);
		usuario.agregarCancion(0, cancionAgregar1);
		usuario.agregarListaDeReproduccion(lista2);
		usuario.agregarListaDeReproduccion(lista);

		// test

		assertEquals(valorEsperado, usuario.getCantidadDeListasDeReproduccion());
	}

	@Test
	public void queSePuedaObtenerLaCantidadDeListasCancionesCuandoSonCero() {

		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		Integer valorEsperado = 0;

		// ejecucion

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);

		// test

		assertEquals(valorEsperado, usuario.getCantidadDeListasDeReproduccion());
	}

}

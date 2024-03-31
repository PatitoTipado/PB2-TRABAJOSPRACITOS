package ar.edu.unlam.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ar.edu.unlam.dominio.*;

public class TestingReproductorDeMusica {

	@Test
	public void queSePuedaAgregarUnaListaDeReproduccionAlReproductor() {
		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		ArrayList<Musica> lista = new ArrayList<Musica>();

		// ejecucion

		ReproductorDeMusica reproductor = new ReproductorDeMusica();

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		reproductor.agregarUnUsuario(usuario);
		// test

		assertTrue(reproductor.agregarListaDeReproduccion(usuario, lista));
	}

	@Test
	public void queNoSePuedaAgregarUnaListaDeReproduccionAlReproductorANoUsuarios() {
		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		ArrayList<Musica> lista = new ArrayList<Musica>();

		// ejecucion

		ReproductorDeMusica reproductor = new ReproductorDeMusica();

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);

		// test

		assertFalse(reproductor.agregarListaDeReproduccion(usuario, lista));
	}

	@Test
	public void queSePuedaAgregarCanciones() {
		// datos de entrada

		Integer dniUsuario = 12, indiceDeLista = 0;
		String nombreUsuario = "Pepe", nombre2 = "pepe";
		ArrayList<Musica> lista2 = new ArrayList<Musica>();

		// ejecucion

		ReproductorDeMusica reproductor = new ReproductorDeMusica();

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		Musica cancionAgregar1 = new Musica(nombre2);

		reproductor.agregarUnUsuario(usuario);
		reproductor.agregarListaDeReproduccion(usuario, lista2);
		// test

		assertTrue(reproductor.agregarCancion(usuario, indiceDeLista, cancionAgregar1));
	}

	@Test
	public void queNoSePuedaAgregarCancionesANoUsuarios() {
		// datos de entrada

		Integer dniUsuario = 12, indiceDeLista = 0;
		String nombreUsuario = "Pepe", nombre2 = "pepe";
		ArrayList<Musica> lista2 = new ArrayList<Musica>();

		// ejecucion

		ReproductorDeMusica reproductor = new ReproductorDeMusica();

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		Musica cancionAgregar1 = new Musica(nombre2);

		reproductor.agregarListaDeReproduccion(usuario, lista2);
		// test

		assertFalse(reproductor.agregarCancion(usuario, indiceDeLista, cancionAgregar1));
	}

	@Test
	public void queSePuedaAgregarMasDeUnaCanciones() {
		// datos de entrada

		Integer dniUsuario = 12, indiceDeLista = 0, valorEsperado = 2;
		String nombreUsuario = "Pepe", nombreDeCancion = "Crysis", nombre2 = "pepe";
		ArrayList<Musica> lista2 = new ArrayList<Musica>();

		// ejecucion

		ReproductorDeMusica reproductor = new ReproductorDeMusica();

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		Musica cancionAgregar = new Musica(nombreDeCancion);
		Musica cancionAgregar1 = new Musica(nombre2);

		reproductor.agregarUnUsuario(usuario);
		reproductor.agregarListaDeReproduccion(usuario, lista2);
		reproductor.agregarCancion(usuario, indiceDeLista, cancionAgregar);
		reproductor.agregarCancion(usuario, indiceDeLista, cancionAgregar1);
		// test

		assertEquals(valorEsperado, reproductor.getCantidadDeCanciones(usuario, indiceDeLista));
	}

	@Test
	public void queSePuedaAgregarMasDeUnaListaCanciones() {
		// datos de entrada

		Integer dniUsuario = 12, valorEsperado = 2;
		String nombreUsuario = "Pepe";
		ArrayList<Musica> lista = new ArrayList<Musica>(), lista2 = new ArrayList<Musica>();

		// ejecucion

		ReproductorDeMusica reproductor = new ReproductorDeMusica();

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);

		reproductor.agregarUnUsuario(usuario);
		reproductor.agregarListaDeReproduccion(usuario, lista2);
		reproductor.agregarListaDeReproduccion(usuario, lista);
		// test

		assertEquals(valorEsperado, reproductor.getCantidadDeListasCanciones(usuario));
	}

	@Test
	public void queNoSePuedaAgregarUnUsuarioSiEsNull() {
		// datos de entrada
		Usuario usuario = null;

		// ejecucion

		ReproductorDeMusica reproductor = new ReproductorDeMusica();

		// test

		assertFalse(reproductor.agregarUnUsuario(usuario));
	}

	@Test
	public void queNoSePuedaAgregarUnaListaCancionesPorQueElUsuarioNoEstaRegistrado() {
		// datos de entrada

		Integer dniUsuario = 12;
		String nombreUsuario = "Pepe";
		ArrayList<Musica> lista = new ArrayList<Musica>();

		// ejecucion

		ReproductorDeMusica reproductor = new ReproductorDeMusica();

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		Usuario usuarioNoRegistrado = new Usuario("pep", 11);

		reproductor.agregarUnUsuario(usuario);
		// test

		assertFalse(reproductor.agregarListaDeReproduccion(usuarioNoRegistrado, lista));
	}

	@Test
	public void queElListadoDeCancionesSeaCorrecto() {
		// datos de entrada

		Integer dniUsuario = 12, indiceDeLista = 0;
		String nombreUsuario = "Pepe", nombreDeCancion = "Crysis", nombre2 = "pepe";
		ArrayList<Musica> lista2 = new ArrayList<Musica>();

		// ejecucion

		ReproductorDeMusica reproductor = new ReproductorDeMusica();

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		Musica cancionAgregar = new Musica(nombreDeCancion);
		Musica cancionAgregar1 = new Musica(nombre2);

		reproductor.agregarUnUsuario(usuario);
		reproductor.agregarListaDeReproduccion(usuario, lista2);
		reproductor.agregarCancion(usuario, indiceDeLista, cancionAgregar);
		reproductor.agregarCancion(usuario, indiceDeLista, cancionAgregar1);
		String valorEsperado = cancionAgregar.toString() + " " + cancionAgregar1.toString() + " ";
		// test

		assertEquals(valorEsperado, reproductor.listadoDeCanciones(usuario, indiceDeLista));
	}

	@Test
	public void queElListadoDeCancionesSeaCorrectoConCeroCanciones() {
		// datos de entrada

		Integer dniUsuario = 12, indiceDeLista = 0;
		String nombreUsuario = "Pepe";
		ArrayList<Musica> lista2 = new ArrayList<Musica>();

		// ejecucion

		ReproductorDeMusica reproductor = new ReproductorDeMusica();

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);

		reproductor.agregarUnUsuario(usuario);
		reproductor.agregarListaDeReproduccion(usuario, lista2);
		String valorEsperado = "";
		// test

		assertEquals(valorEsperado, reproductor.listadoDeCanciones(usuario, indiceDeLista));
	}

	@Test
	public void queLaCantidadDeCancionesSeaCorrecto() {
		// datos de entrada

		Integer dniUsuario = 12, indiceDeLista = 0;
		String nombreUsuario = "Pepe", nombreDeCancion = "Crysis", nombre2 = "pepe";
		ArrayList<Musica> lista2 = new ArrayList<Musica>();

		// ejecucion

		ReproductorDeMusica reproductor = new ReproductorDeMusica();

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);
		Musica cancionAgregar = new Musica(nombreDeCancion);
		Musica cancionAgregar1 = new Musica(nombre2);

		reproductor.agregarUnUsuario(usuario);
		reproductor.agregarListaDeReproduccion(usuario, lista2);
		reproductor.agregarCancion(usuario, indiceDeLista, cancionAgregar);
		reproductor.agregarCancion(usuario, indiceDeLista, cancionAgregar1);
		Integer valorEsperado = 2;
		// test

		assertEquals(valorEsperado, reproductor.getCantidadDeCanciones(usuario, indiceDeLista));
	}

	@Test
	public void queLaCantidadDeCancionesSeaCorrectoSiEsCero() {
		// datos de entrada

		Integer dniUsuario = 12, indiceDeLista = 0;
		String nombreUsuario = "Pepe";
		ArrayList<Musica> lista2 = new ArrayList<Musica>();

		// ejecucion

		ReproductorDeMusica reproductor = new ReproductorDeMusica();

		Usuario usuario = new Usuario(nombreUsuario, dniUsuario);

		reproductor.agregarUnUsuario(usuario);
		reproductor.agregarListaDeReproduccion(usuario, lista2);
		Integer valorEsperado = 0;
		// test

		assertEquals(valorEsperado, reproductor.getCantidadDeCanciones(usuario, indiceDeLista));
	}

}

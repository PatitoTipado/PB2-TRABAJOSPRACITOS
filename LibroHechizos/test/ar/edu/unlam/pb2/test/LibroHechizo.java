package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.Agrandar;
import ar.edu.unlam.pb2.dominio.Animal;
import ar.edu.unlam.pb2.dominio.Expelliarmus;
import ar.edu.unlam.pb2.dominio.Hechizable;
import ar.edu.unlam.pb2.dominio.Hechizo;
import ar.edu.unlam.pb2.dominio.HechizoNoEncontrado;
import ar.edu.unlam.pb2.dominio.LibroDeHechizos;
import ar.edu.unlam.pb2.dominio.Mueble;

public class LibroHechizo {

	@Test
	public void queSePuedaAgregarUnHechizoAlLibro() throws HechizoNoEncontrado {
		LibroDeHechizos libro = new LibroDeHechizos();
		Hechizo desarme = new Expelliarmus();
		libro.agregarHechizo(desarme);
		assertEquals(desarme, libro.buscar("expelliarmus"));
	}

	@Test
	public void verSiUnHechizableEstaHechizado() throws HechizoNoEncontrado {
		LibroDeHechizos libro = new LibroDeHechizos();
		Expelliarmus desarme = new Expelliarmus();
		Hechizable perro = new Animal();
		libro.agregarHechizo(desarme);
		Hechizo hechizo = libro.buscar("expelliarmus");
		hechizo.aplicarHechizo(perro);
		assertEquals("Me desarmaron", perro.getEstado());
	}
	
	@Test (expected= HechizoNoEncontrado.class)
	public void siNoEncuentraElHechizoLanzaExpetion() throws HechizoNoEncontrado {
		LibroDeHechizos libro = new LibroDeHechizos();
		Hechizable perro = new Animal();
		Hechizo hechizo = libro.buscar("expelliarmus");
		hechizo.aplicarHechizo(perro);
		assertEquals("Me desarmaron", perro.getEstado());
	}
	
	@Test
	public void verSiUnHechizableCrece() throws HechizoNoEncontrado {
		LibroDeHechizos libro = new LibroDeHechizos();
		Hechizo crecer = new Agrandar("enormuvus");
		Hechizable mesa = new Mueble();
		libro.agregarHechizo(crecer);
		Hechizo hechizo = libro.buscar("enormuvus");
		hechizo.aplicarHechizo(mesa);
		assertEquals("Ahora soy más grande", mesa.getEstado());
	}
}

package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.*;

public class AlarmaTest {

	@Test
	public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma() throws NoEsUnUsuarioConfiguradorExeptions {

		String nombre = "puerta";
		Integer codigoActivacion = 123;

		Alarma alarma = new Alarma(nombre, codigoActivacion);

		assertTrue(alarma.agregarUsuario(new Usuario("Pablo", "CONFIGURADOR")));
	}

	@Test(expected = NoEsUnUsuarioConfiguradorExeptions.class)
	public void queNoSePuedaAgregarUnUsuarioNoConfiguradorAUnaAlarma() throws NoEsUnUsuarioConfiguradorExeptions {

		String nombre = "puerta";
		Integer codigoActivacion = 123;

		Alarma alarma = new Alarma(nombre, codigoActivacion);

		assertTrue(alarma.agregarUsuario(new Usuario("Pablo", "ACTIVADOR")));
	}

}

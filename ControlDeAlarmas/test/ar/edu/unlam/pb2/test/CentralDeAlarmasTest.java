package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.*;

public class CentralDeAlarmasTest {

	@Test
	public void queSePuedaRegistrarUnaAlarmaEnLaCentral() {

		String nombre = "puerta";
		Integer codigoActivacion = 123;

		Central central = new Central();

		Alarma alarma = new Alarma(nombre, codigoActivacion);

		assertTrue(central.agregarAlarma(alarma));
	}

	@Test
	public void queSePuedaAgregarUnUsuario() {
		Central central = new Central();
		Usuario usuario = new Usuario("roberto", "CONFIGURADOR");
		assertTrue(central.agregarUsuario(usuario));
	}

	@Test(expected = CodigoAlarmaIncorrectoException.class)
	public void alAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSeLanceCodigoAlarmaIncorrectoException()
			throws CodigoAlarmaIncorrectoException, NoEsUnUsuarioConfiguradorExeptions {

		String nombre = "puerta";
		Integer codigoActivacion = 123;

		Central central = new Central();

		Alarma alarma = new Alarma(nombre, codigoActivacion);

		central.agregarAlarma(alarma);

		central.agregarUsuarioAUnaAlarma(000, 2, nombre);

	}

}

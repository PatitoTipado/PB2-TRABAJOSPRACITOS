package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.SalaDeCine;

public class SalaDeCineTest {

	/*
	 * PREGUNTAS ¿para testear este metodo debo asegurarme que los demas esten bien
	 * tmb, por que me sirven para testearlo. supongo que los tengo medianamente no
	 * accesibles o un sotware malo supongo que llendo para atras en los metodos que
	 * tengo que usar, podriamos verificar cual usar primero, pero como me doy
	 * cuenta de que metodo testear primero hay una forma? ¿es una buena practica
	 * que los test esten en cascada de forma que primero verifique el
	 * funcionamiento de cada uno?
	 * tengo que probar los gets?
	 */

	@Test
	public void queCuandoPaseParametrosNoValidosSeaFalsaLaConsultaDeLaButaca() {

		// preparacion de datos

		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Boolean verificarConsulta = true;
		Integer parametroNoValido = 3;

		// ejecucion

		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		verificarConsulta = miCine.consultarSiLaButacaEstaVacia(parametroNoValido, parametroNoValido);
		// test
		assertFalse(verificarConsulta);
	}

	@Test
	public void queCuandoPaseParametrosValidosSeaVerdaderaLaConsultaDeLaButaca() {

		// preparacion de datos

		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Boolean verificarConsulta = false;
		Integer parametroValido = 0;

		// ejecucion

		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		verificarConsulta = miCine.consultarSiLaButacaEstaVacia(parametroValido, parametroValido);
		// test
		assertTrue(verificarConsulta);
	}

	@Test
	public void queNoPuedaUtilizarUnaButacaInexistente() {

		// preparacion de datos

		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Boolean verificarConsulta = true;
		Integer parametroNoValido = 3;

		// ejecucion

		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		verificarConsulta = miCine.utilizarButaca(parametroNoValido, parametroNoValido);
		// test
		assertFalse(verificarConsulta);
	}

	@Test
	public void quePuedaUtilizarUnaButacaExistente() {

		// preparacion de datos

		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Boolean verificarConsulta = true;
		Integer parametroValido = 0;

		// ejecucion

		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		verificarConsulta = miCine.utilizarButaca(parametroValido, parametroValido);
		// test
		assertTrue(verificarConsulta);
	}

	@Test
	public void queNoPuedaUtilizarUnaButacaOcupada() {

		// preparacion de datos

		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Boolean verificarConsulta = true;
		Integer parametroValido = 0;

		// ejecucion

		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		verificarConsulta = miCine.utilizarButaca(parametroValido, parametroValido);
		verificarConsulta = miCine.utilizarButaca(parametroValido, parametroValido);

		// test
		assertFalse(verificarConsulta);
	}

	@Test
	public void queCuandoEsteOcupadaSeaFalsaLaConsultaDeLaButaca() {

		// preparacion de datos

		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Boolean verificarConsulta = true;
		Integer parametroValido = 0;

		// ejecucion

		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		miCine.utilizarButaca(parametroValido, parametroValido);
		verificarConsulta = miCine.consultarSiLaButacaEstaVacia(parametroValido, parametroValido);
		// test
		assertFalse(verificarConsulta);
	}

	@Test
	public void queEnLaSalaDeCinePreparenButacas() {

		// preparacion de datos

		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Boolean prepararButacas = true;

		// ejecucion

		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		for (int i = 0; i < miCine.getCantidadDeFilas() && prepararButacas; i++) {
			for (int j = 0; j < miCine.getCantidadDeColumnas() && prepararButacas; j++) {
				if (!miCine.consultarSiLaButacaEstaVacia(i, j)) {
					prepararButacas = false;
				}
			}

		}

		// test
		assertTrue(prepararButacas);
	}

	@Test
	public void queLaSalaDeCineEsteVacia() {

		// preparacion de datos
		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Boolean estaVacia = false;
		// ejecucion
		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		estaVacia = miCine.consultarSiLaSalaEstaVacia();
		// test
		assertTrue(estaVacia);
	}

	@Test
	public void queLaSalaDeCineNoEsteVacia() {

		// preparacion de datos
		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Integer numeroDeFila = 0;
		Integer numeroDeColumna = 0;
		Boolean estaVacia = false;
		// ejecucion
		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		miCine.utilizarButaca(numeroDeFila, numeroDeColumna);
		estaVacia = miCine.consultarSiLaSalaEstaVacia();
		// test
		assertFalse(estaVacia);
	}

	@Test
	public void queNoSePuedaAcomodarAAlguienFueraDeLosLimites() {

		// preparacion de datos
		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Integer numeroDeFila = 0;
		Integer numeroDeColumna = 0;
		Integer cantidadDePersonas = 3;
		Boolean estaAfueraDelLimite = false;
		// ejecucion
		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		estaAfueraDelLimite = miCine.sePuedeAcomodarContinuamente(numeroDeFila, numeroDeColumna, cantidadDePersonas);
		// test
		assertFalse(estaAfueraDelLimite);
	}

	@Test
	public void queSePuedaAcomodarAAlguienDentroDelLimite() {

		// preparacion de datos
		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Integer numeroDeFila = 0;
		Integer numeroDeColumna = 0;
		Integer cantidadDePersonas = 2;
		Boolean estaAfueraDelLimite = false;
		// ejecucion
		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		estaAfueraDelLimite = miCine.sePuedeAcomodarContinuamente(numeroDeFila, numeroDeColumna, cantidadDePersonas);
		// test
		assertTrue(estaAfueraDelLimite);
	}

	@Test
	public void queNoSePuedaEmpezarAAcomodarDesdeAfueraDelLimite() {

		// preparacion de datos
		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Integer numeroDeFila = 3;
		Integer numeroDeColumna = 3;
		Integer cantidadDePersonas = 2;
		Boolean estaAfueraDelLimite = false;
		// ejecucion
		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		estaAfueraDelLimite = miCine.sePuedeAcomodarContinuamente(numeroDeFila, numeroDeColumna, cantidadDePersonas);
		// test
		assertFalse(estaAfueraDelLimite);
	}

	@Test
	public void queLaSalaTengaNoTengaButacasDisponibles() {

		// preparacion de datos
		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Integer numeroDeFila = 0;
		Integer numeroDeColumna = 0;
		Integer cantidadDeButacasEsperadas = 0;
		Integer cantidadDeButacasTotales = Integer.MAX_VALUE;
		// ejecucion
		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);

		for (int i = 0; i < miCine.getCantidadDeFilas(); i++) {
			for (int j = 0; j < miCine.getCantidadDeColumnas(); j++) {
				miCine.utilizarButaca(numeroDeFila, numeroDeColumna);
				numeroDeColumna++;
			}
			numeroDeFila++;
			numeroDeColumna = 0;
		}

		cantidadDeButacasTotales = miCine.cantidadDeButacasTotalesDisponibles();
		// test
		assertEquals(cantidadDeButacasEsperadas, cantidadDeButacasTotales);
	}

	@Test
	public void queLaSalaTengaTodasLasButacasDisponibles() {

		// preparacion de datos

		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Integer cantidadDeButacasDisponibles = Integer.MAX_VALUE;
		Integer cantidadDeButacasEsperadas = 4;

		// ejecucion

		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		cantidadDeButacasDisponibles = miCine.cantidadDeButacasTotalesDisponibles();

		// test
		assertEquals(cantidadDeButacasEsperadas, cantidadDeButacasDisponibles);
	}

	@Test
	public void queLaSalaTenga2ButacasDisponibles() {

		// preparacion de datos
		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Integer numeroDeFila = 0;
		Integer numeroDeColumna = 0;
		Integer cantidadDeButacasEsperadas = 2;
		Integer cantidadDeButacasTotales = Integer.MAX_VALUE;
		Integer cantidadDeButacasAUtilizar = 2;
		// ejecucion
		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);

		for (int i = 0; i < cantidadDeButacasAUtilizar; i++) {
			miCine.utilizarButaca(numeroDeFila, numeroDeColumna);
			numeroDeColumna++;
		}

		cantidadDeButacasTotales = miCine.cantidadDeButacasTotalesDisponibles();
		// test
		assertEquals(cantidadDeButacasEsperadas, cantidadDeButacasTotales);
	}

	@Test
	public void queLaSalaTengaTodasLasButacasOcupadas() {

		// preparacion de datos
		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Integer numeroDeFila = 0;
		Integer numeroDeColumna = 0;
		Integer cantidadDeButacasEsperadas = 4;
		Integer cantidadDeButacasTotales = Integer.MAX_VALUE;
		// ejecucion
		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);

		for (int i = 0; i < miCine.getCantidadDeFilas(); i++) {
			for (int j = 0; j < miCine.getCantidadDeColumnas(); j++) {
				miCine.utilizarButaca(numeroDeFila, numeroDeColumna);
				numeroDeColumna++;
			}
			numeroDeFila++;
			numeroDeColumna = 0;
		}

		cantidadDeButacasTotales = miCine.cantidadDeButacasTotalesOcupadas();
		// test
		assertEquals(cantidadDeButacasEsperadas, cantidadDeButacasTotales);
	}

	@Test
	public void queLaSalaTengaTodasLasButacasDesocupadas() {

		// preparacion de datos

		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Integer cantidadDeButacasDisponibles = Integer.MAX_VALUE;
		Integer cantidadDeButacasEsperadas = 0;

		// ejecucion

		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);
		cantidadDeButacasDisponibles = miCine.cantidadDeButacasTotalesOcupadas();

		// test
		assertEquals(cantidadDeButacasEsperadas, cantidadDeButacasDisponibles);
	}

	@Test
	public void queLaSalaTenga2ButacasOcupadas() {

		// preparacion de datos
		Integer cantidadDeFilas = 2;
		Integer cantidadDeColumnas = 2;
		Integer numeroDeFila = 0;
		Integer numeroDeColumna = 0;
		Integer cantidadDeButacasEsperadas = 2;
		Integer cantidadDeButacasTotales = Integer.MAX_VALUE;
		Integer cantidadDeButacasAUtilizar = 2;
		// ejecucion
		SalaDeCine miCine = new SalaDeCine(cantidadDeFilas, cantidadDeColumnas);

		for (int i = 0; i < cantidadDeButacasAUtilizar; i++) {
			miCine.utilizarButaca(numeroDeFila, numeroDeColumna);
			numeroDeColumna++;
		}

		cantidadDeButacasTotales = miCine.cantidadDeButacasTotalesOcupadas();
		// test
		assertEquals(cantidadDeButacasEsperadas, cantidadDeButacasTotales);
	}

}

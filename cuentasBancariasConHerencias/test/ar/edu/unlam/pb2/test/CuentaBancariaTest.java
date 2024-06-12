package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.CajaDeAhorro;
import ar.edu.unlam.pb2.dominio.CuentaCorriente;
import ar.edu.unlam.pb2.dominio.CuentaSueldo;

public class CuentaBancariaTest {

	@Test
	public void cuentaSueldoQueSePuedaIngresarSaldo() {

		Double cantidadAIngresar = 500.0;

		CuentaSueldo cuenta = new CuentaSueldo();

		Boolean deposito = cuenta.depositar(cantidadAIngresar);

		assertTrue(deposito);
	}

	@Test
	public void cuentaSueldoQueNoSePuedaIngresarSaldoSiEsMenorACero() {

		Double cantidadAIngresar = -500.0;

		CuentaSueldo cuenta = new CuentaSueldo();

		Boolean deposito = cuenta.depositar(cantidadAIngresar);

		assertFalse(deposito);
	}

	@Test
	public void cuentaSueldoQueSePuedaExtraerSiTieneDineroDisponible() {

		Double cantidadAIngresar = 500.0;
		Double cantidadAExtraer = 500.0;

		CuentaSueldo cuenta = new CuentaSueldo();

		cuenta.depositar(cantidadAIngresar);

		Boolean sePudoExtraer = cuenta.extraer(cantidadAExtraer);

		assertTrue(sePudoExtraer);

		assertEquals(Double.valueOf(0), Double.valueOf(cuenta.getSaldo()));

	}

	@Test
	public void cuentaSueldoQueNoSePuedaExtraerSiNoTieneDineroDisponible() {

		Double cantidadAExtraer = 500.0;

		CuentaSueldo cuenta = new CuentaSueldo();

		assertFalse(cuenta.extraer(cantidadAExtraer));

	}

	@Test
	public void cajaDeAhorroQueSePuedaIngresarSaldo() {

		Double cantidadAIngresar = 500.0;

		CajaDeAhorro cuenta = new CajaDeAhorro();

		Boolean deposito = cuenta.depositar(cantidadAIngresar);

		assertTrue(deposito);

	}

	@Test
	public void cajaDeAhorroQueNoSePuedaIngresarSaldoSiEsMenorACero() {

		Double cantidadAIngresar = -500.0;

		CajaDeAhorro cuenta = new CajaDeAhorro();

		Boolean deposito = cuenta.depositar(cantidadAIngresar);

		assertFalse(deposito);
	}

	@Test
	public void cajaDeAhorroQueSePuedaExtraerSiTieneDineroDisponible() {

		Double cantidadAIngresar = 500.0;
		Double cantidadAExtraer = 500.0;

		CajaDeAhorro cuenta = new CajaDeAhorro();

		cuenta.depositar(cantidadAIngresar);

		Boolean sePudoExtraer = cuenta.extraer(cantidadAExtraer);

		assertTrue(sePudoExtraer);

		assertEquals(Double.valueOf(0), Double.valueOf(cuenta.getSaldo()));

	}

	@Test
	public void cajaDeAhoroQueNoSePuedaSacarSiNoTieneDineroDisponible() {

		Double cantidadAExtraer = 500.0;

		CajaDeAhorro cuenta = new CajaDeAhorro();

		assertFalse(cuenta.extraer(cantidadAExtraer));

	}

	@Test
	public void cajaDeAhoroQueALaSextaExtraccionLeCobreUnAdicional() {

		Double cantidadAIngresar = 606.0;
		Double cantidadAExtraer = 100.0;
		Integer vueltas = 6;
		Boolean sePudoExtraer = false;
		
		CajaDeAhorro cuenta = new CajaDeAhorro();
		cuenta.depositar(cantidadAIngresar);

		for (int i = 0; i < vueltas; i++) {

			sePudoExtraer = cuenta.extraer(cantidadAExtraer);

		}

		assertTrue(sePudoExtraer);

		assertEquals(Double.valueOf(0), Double.valueOf(cuenta.getSaldo()));
	}

//	/*tope que puede girar al descubierto, este seria un tipo de credito
//	*
//	*CuentaCorrienteQuePuedaIngresarDinero
//	*
//	*cuentaCorrienteQuePuedaExtraerElMaximoIngresadoSinDescubierto
//	*
//	*cuentaCorrienteQueLuegoDeExtraerElMaximoPuedaExtraerElDescubierto
//	*
//	*cuentaCorrienteQueExtraerElDescubiertoYElTotalDeSucuenta
//	*
//	*cuentaCorrienteQueNoPuedaSacarUnaMayorCantidadQueElDescubierto
//	*
//	*/
	@Test
	public void CuentaCorrienteQuePuedaIngresarDinero() {
		
		Double cantidadAIngresar = 500.0;

		CuentaCorriente cuenta = new CuentaCorriente();

		Boolean deposito = cuenta.depositar(cantidadAIngresar);

		assertTrue(deposito);

	}
	
	@Test
	public void cuentaCorrienteQuePuedaExtraerElMaximoIngresadoSinDescubierto() {
		
		Double cantidadAIngresar = 500.0;

		CuentaCorriente cuenta = new CuentaCorriente();

		cuenta.depositar(cantidadAIngresar);

		assertTrue(cuenta.extraer(cantidadAIngresar));
		assertEquals(Double.valueOf(0), cuenta.getSaldo());

	}
	
	@Test
	public void cuentaCorrienteQueLuegoDeExtraerElMaximoPuedaExtraerElDescubierto() {
		
		Double cantidadAIngresar = 500.0;

		CuentaCorriente cuenta = new CuentaCorriente();

		cuenta.depositar(cantidadAIngresar);
		cuenta.extraer(cantidadAIngresar);
		assertTrue(cuenta.extraer(Double.valueOf(100)));
		assertEquals(Double.valueOf(45.0), cuenta.getDescubierto());
		assertEquals(Double.valueOf(0.0), cuenta.getSaldo());

		
	}
	
	@Test
	public void cuentaCorrienteExtraerElMaximoQuePuedaConElDescubierto() {
		
		Double cantidadAIngresar = 500.0;

		CuentaCorriente cuenta = new CuentaCorriente();

		cuenta.depositar(cantidadAIngresar);
		
		assertTrue(cuenta.extraer(Double.valueOf(600)));
		assertEquals(Double.valueOf(0.0), cuenta.getSaldo());
	}

	
	@Test
	public void cuentaCorrienteQueNoPuedaSacarUnaMayorCantidadQueElDescubierto() {
		
		Double cantidadAIngresar = 500.0;
		Double valorInvalido=600.0;

		CuentaCorriente cuenta = new CuentaCorriente();

		cuenta.depositar(cantidadAIngresar);
		cuenta.extraer(cantidadAIngresar);
		assertFalse(cuenta.extraer(valorInvalido));
		
	}

}

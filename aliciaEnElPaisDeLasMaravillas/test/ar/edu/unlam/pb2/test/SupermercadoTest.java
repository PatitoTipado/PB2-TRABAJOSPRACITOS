package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.*;

public class SupermercadoTest {

	@Test
	public void QueAlComprarUnAlimentoSeDescuenteElDineroDisponible() throws NoPudoComprarloExeptions {

		// el supermercado al abrir este mismo me deberia poder ofrecer lo que quiero
		Double dinero = 1000.0;

		Supermercado supermercado = new Supermercado();

		Alicia alicia = new Alicia(dinero);

		// alimento que quiero comprar

		Agrandador caramelo = new Caramelo();

		supermercado.comprar(alicia, caramelo);

		Double saldoEsperado = 800.0;
		assertEquals(saldoEsperado, alicia.getSaldo());
	}

	@Test (expected= NoPudoComprarloExeptions.class)
	public void queNoPuedaComparSiNoTienedineroSuficiente() throws NoPudoComprarloExeptions {

		// el supermercado al abrir este mismo me deberia poder ofrecer lo que quiero
		Double dinero = 180.0;

		Supermercado supermercado = new Supermercado();

		Alicia alicia = new Alicia(dinero);

		// alimento que quiero comprar

		Agrandador caramelo = new Caramelo();

		supermercado.comprar(alicia, caramelo);
	}

}

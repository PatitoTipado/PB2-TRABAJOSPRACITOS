package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.*;

public class FelizNoCumpleanios {

	@Test
	public void queAlConsumirUnAgrandadorQueSeAgrande() throws NoPudoComprarloExeptions, NoPuedeAgrandarseMasExeptions {

		// el supermercado al abrir este mismo me deberia poder ofrecer lo que quiero
		Double dinero = 1000.0;

		Supermercado supermercado = new Supermercado();

		Alicia alicia = new Alicia(dinero);

		// alimento que quiero comprar

		Agrandador caramelo = new Caramelo();

		supermercado.comprar(alicia, caramelo);

		alicia.consumirAlimentoAgrandador(caramelo);

		Double alturaEsperada = 220.0;
		assertEquals(alturaEsperada, alicia.getAltura());

	}

	@Test
	public void queAlConsumirUnAchicadorQueSeAchique() throws NoPudoComprarloExeptions, NoPuedeAchicarseMasExeptions {

		// el supermercado al abrir este mismo me deberia poder ofrecer lo que quiero
		Double dinero = 1000.0;

		Supermercado supermercado = new Supermercado();

		Alicia alicia = new Alicia(dinero);

		// alimento que quiero comprar

		Achicador alfajor = new Alfajor();

		supermercado.comprar(alicia, alfajor);

		alicia.consumirAlimentoAchicador(alfajor);

		Double alturaEsperada = 130.0;
		assertEquals(alturaEsperada, alicia.getAltura());

	}

	@Test(expected = NoPuedeAchicarseMasExeptions.class)
	public void queAlConsumirUnAchicadorQueNoSeAchiquePorNoTenerAlturaSuficiente()
			throws NoPudoComprarloExeptions, NoPuedeAchicarseMasExeptions {

		// el supermercado al abrir este mismo me deberia poder ofrecer lo que quiero
		Double dinero = 1000.0;

		Supermercado supermercado = new Supermercado();

		Alicia alicia = new Alicia(dinero);

		// alimento que quiero comprar

		Achicador alfajor = new Alfajor();

		supermercado.comprar(alicia, alfajor);
		supermercado.comprar(alicia, alfajor);
		supermercado.comprar(alicia, alfajor);

		alicia.consumirAlimentoAchicador(alfajor);
		alicia.consumirAlimentoAchicador(alfajor);
		alicia.consumirAlimentoAchicador(alfajor);

	}

	@Test(expected = NoPuedeAgrandarseMasExeptions.class)
	public void queAlConsumirUnAgrandadorQueNoSeAgrandePorNoTenerAlturaSuficiente()
			throws NoPudoComprarloExeptions, NoPuedeAgrandarseMasExeptions {

		// el supermercado al abrir este mismo me deberia poder ofrecer lo que quiero
		Double dinero = 1000.0;

		Supermercado supermercado = new Supermercado();

		Alicia alicia = new Alicia(dinero);

		// alimento que quiero comprar

		Agrandador caramelo = new Caramelo();

		supermercado.comprar(alicia, caramelo);
		supermercado.comprar(alicia, caramelo);
		supermercado.comprar(alicia, caramelo);

		alicia.consumirAlimentoAgrandador(caramelo);
		alicia.consumirAlimentoAgrandador(caramelo);
		alicia.consumirAlimentoAgrandador(caramelo);

	}

	@Test
	public void ordenarColeccionDeManeraDesendente() throws NoPudoComprarloExeptions {

		Double dinero = 2000.0;

		Supermercado supermercado = new Supermercado();

		Alicia alicia = new Alicia(dinero);

		// alimento que quiero comprar

		Agrandador caramelo = new Caramelo();

		Achicador alfajor = new Alfajor();

		supermercado.comprar(alicia, caramelo);
		supermercado.comprar(alicia, alfajor);

		LinkedList<Alimento> alimento = new LinkedList<>();

		alimento.add(alfajor);
		alimento.add(caramelo);

		assertEquals(alimento, alicia.getAlimentos());
	}

}

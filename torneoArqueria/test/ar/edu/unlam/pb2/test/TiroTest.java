package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.Tiro;
import ar.edu.unlam.pb2.dominio.TiroInvalidoExeption;

public class TiroTest {

	@Test
	public void obtenerCoordenadasDelTiro() {
		
		Double coordenadaX= 3.0;
		Double coordenadaY=4.0;
		Double esperadaX=3.0;
		Double esperadaY=4.0;
		
		//desde que se inicia debe saber en donde paro el tiro
		Tiro disparo = new Tiro(coordenadaX,coordenadaY);
		
		assertEquals(esperadaX,disparo.getCoordenadaX());
		assertEquals(esperadaY,disparo.getCoordenadaY());

	}
	
	@Test
	public void determinarCuantaDistanciaTieneElTiro() throws TiroInvalidoExeption{

		Double coordenadaX= 3.0;
		Double coordenadaY=4.0;
		
		//desde que se inicia debe saber en donde paro el tiro
		Tiro disparo = new Tiro(coordenadaX,coordenadaY);
		
		Double distanciaEsperada=5.0;
		
		assertEquals(distanciaEsperada,disparo.distancia());
	}

	@Test
	public void determinarCuantoPuntajeTieneElTiro() throws TiroInvalidoExeption {

		Double coordenadaX= 3.0;
		Double coordenadaY=4.0;
		
		//desde que se inicia debe saber en donde paro el tiro
		Tiro disparo = new Tiro(coordenadaX,coordenadaY);
		
		Integer puntajeEsperado=1000;
		
		assertEquals(puntajeEsperado,disparo.puntaje());
	}
	@Test
	public void tiroConPuntajeInvalido() throws TiroInvalidoExeption {

		Double coordenadaX= 400.0;
		Double coordenadaY=400.0;
		
		//desde que se inicia debe saber en donde paro el tiro
		Tiro disparo = new Tiro(coordenadaX,coordenadaY);
				
		assertEquals(Integer.valueOf(-1), disparo.puntaje());
	
	}

}

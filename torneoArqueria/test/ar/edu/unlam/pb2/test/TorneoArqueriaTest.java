package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.*;

public class TorneoArqueriaTest {

	/*
	 * Se te pide que ayudes a los organizadores a clasificar a los participantes e
	 * informar el podio (1°, 2° y 3° puesto).
	 */
	@Test
	public void informarElPodio() throws TiroInvalidoExeption, ParticipanteNoCalificadoExeption {
				
		Double coordenadaX= 3.0;
		Double coordenadaY=3.0;

		Arquero arquero = new Arquero();
		Arquero arquero2= new Arquero();
		Arquero arquero3= new Arquero();
		
		arquero.realizarDisparo(coordenadaX+20,coordenadaY);
		arquero.realizarDisparo(coordenadaX+20,coordenadaY);
		arquero.realizarDisparo(coordenadaX,coordenadaY);
		arquero.realizarDisparo(coordenadaX+20,coordenadaY);
		arquero.realizarDisparo(coordenadaX+20,coordenadaY);
		
		arquero2.realizarDisparo(coordenadaX+1,coordenadaY);
		arquero2.realizarDisparo(coordenadaX+2,coordenadaY);
		arquero2.realizarDisparo(coordenadaX,coordenadaY);
		arquero2.realizarDisparo(coordenadaX+3,coordenadaY);
		arquero2.realizarDisparo(coordenadaX+4,coordenadaY);
		arquero2.realizarDisparo(coordenadaX+30,coordenadaY);
		arquero2.realizarDisparo(coordenadaX+30,coordenadaY);

		arquero3.realizarDisparo(coordenadaX+30,coordenadaY);
		arquero3.realizarDisparo(coordenadaX+30,coordenadaY);
		arquero3.realizarDisparo(coordenadaX,coordenadaY);
		arquero3.realizarDisparo(coordenadaX+30,coordenadaY);
		arquero3.realizarDisparo(coordenadaX+30,coordenadaY);
		
		Torneo torneo= new Torneo();
		
		torneo.agregarParticipante(arquero3);
		torneo.agregarParticipante(arquero);
		torneo.agregarParticipante(arquero2);
		
		TreeMap<Integer,Arquero> arqueros = new TreeMap<Integer,Arquero>(Collections.reverseOrder());
		arqueros.put(arquero2.obtenerPuntajeTotal(),arquero2);
		arqueros.put(arquero.obtenerPuntajeTotal(),arquero);
		arqueros.put(arquero3.obtenerPuntajeTotal(),arquero3);
		
		System.out.println(arqueros.values());
		
		System.out.println(arquero2.obtenerPuntajeTotal()); //ID 1
		System.out.println(arquero.obtenerPuntajeTotal()); //ID 0
		System.out.println(arquero3.obtenerPuntajeTotal()); //ID 2

		assertEquals(arqueros,torneo.obtenerPodio());
		
	}

}

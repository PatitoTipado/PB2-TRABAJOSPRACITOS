package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.Motocicleta;
import ar.edu.unlam.pb2.dominio.Persona;

public class EmpresaDeTransporteTest {

	@Test
	public void motocicletaPuedeIngresarUnAcompañante() {
		
		String nombre="pepe";
		
		Persona pasajero= new Persona(nombre);
		
		Motocicleta motocicleta = new Motocicleta();
		
		motocicleta.ingresarPasajero(pasajero);
		
	}
	@Test
	public void motocicletaNoPuedeLlevarADosPasajeros() {
		
		String nombre="pepe";
		
		Persona chofer = new Persona(nombre);
		Persona acompañante= new Persona(nombre);
		
		Motocicleta motocicleta = new Motocicleta();
		
	}

}

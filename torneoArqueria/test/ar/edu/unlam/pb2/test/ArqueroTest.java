package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;
import ar.edu.unlam.pb2.dominio.Arquero;
import ar.edu.unlam.pb2.dominio.ParticipanteNoCalificadoExeption;
import ar.edu.unlam.pb2.dominio.Tiro;
import ar.edu.unlam.pb2.dominio.TiroInvalidoExeption;

public class ArqueroTest {
	
	//que pueda disparar un tiro y se guarde en un linked 
	@Test
	public void quePuedaTirarUnTiroValido() throws TiroInvalidoExeption {
		
		Double coordenadaX= 3.0;
		Double coordenadaY=3.0;

		Arquero arquero = new Arquero();
		
		arquero.realizarDisparo(coordenadaX,coordenadaY);
		
	}
	//que no guarde tiros invalidos 
	@Test (expected=TiroInvalidoExeption.class)
	public void queNoPuedaTirarUnTiroValido() throws TiroInvalidoExeption {
		
		Double coordenadaX= 500.0;
		Double coordenadaY=500.0;

		Arquero arquero = new Arquero();
		
		arquero.realizarDisparo(coordenadaX,coordenadaY);
		
		Integer esperado =0;
		assertEquals (esperado,arquero.getCantidadDeDisparosRealizados());
	}
	//que pueda dar sus 5 mejores tiros
	@Test
	public void queMeDeSusCincoMejoresTiros() throws TiroInvalidoExeption, ParticipanteNoCalificadoExeption {
		//de primeras debera aceptar tiros repetidos 
		Double coordenadaX= 3.0;
		Double coordenadaY=3.0;

		Arquero arquero = new Arquero();
		
		arquero.realizarDisparo(coordenadaX+40,coordenadaY);
		arquero.realizarDisparo(coordenadaX+30,coordenadaY);
		arquero.realizarDisparo(coordenadaX,coordenadaY);
		arquero.realizarDisparo(coordenadaX+10,coordenadaY);
		arquero.realizarDisparo(coordenadaX+20,coordenadaY);
		arquero.realizarDisparo(coordenadaX+42,coordenadaY);
		arquero.realizarDisparo(coordenadaX+45,coordenadaY);

		
		LinkedList<Tiro> tiros = new LinkedList<Tiro>();
		
		tiros.add(new Tiro(coordenadaX,coordenadaY));
		tiros.add(new Tiro(coordenadaX+10,coordenadaY));
		tiros.add(new Tiro(coordenadaX+20,coordenadaY));
		tiros.add(new Tiro(coordenadaX+30,coordenadaY));
		tiros.add(new Tiro(coordenadaX+40,coordenadaY));

		assertEquals(tiros,arquero.losCincoMejoresTiros());
	}
	//que tire una exepcion cuando no pueda dar la cantidad de tiros validos
	@Test (expected=ParticipanteNoCalificadoExeption.class)
	public void queMeLanceExeptionSiNoTieneLaCantidadDeTirosValidos() throws TiroInvalidoExeption, ParticipanteNoCalificadoExeption {
		Double coordenadaX= 3.0;
		Double coordenadaY=3.0;

		Arquero arquero = new Arquero();
		
		arquero.realizarDisparo(coordenadaX+40,coordenadaY);
		arquero.realizarDisparo(coordenadaX+30,coordenadaY);
		arquero.realizarDisparo(coordenadaX,coordenadaY);
		arquero.realizarDisparo(coordenadaX+10,coordenadaY);
		
		arquero.losCincoMejoresTiros();
	}
	
}

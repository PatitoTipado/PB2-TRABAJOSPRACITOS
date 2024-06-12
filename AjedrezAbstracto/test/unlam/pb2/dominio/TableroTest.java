package unlam.pb2.dominio;

import static org.junit.Assert.*;
import org.junit.Test;

public class TableroTest {

	@Test
	public void ubicacionPeon() {
		Peon primerPeon= new Peon();
		String ubicacion= primerPeon.ubicacion();
		String ubicacionEsperada= "A2";
		assertEquals(ubicacionEsperada, ubicacion);
	}
	
	@Test
	public void estaViva() {
		Peon primerPeon= new Peon();
		Boolean estaViva= primerPeon.getEstaViva();
		assertTrue(estaViva);
	}

}

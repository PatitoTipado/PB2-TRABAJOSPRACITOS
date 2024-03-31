package ar.edu.unlam.pb2.intraconsulta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUniversidad {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void queSePuedaRegistrarAlumno() {

		// datos
		
		String nombreUniversidad = "Unlam", domicilido = "", nombreAlumno = "pepito", apellidoAlumno = "Perez";
		Integer dni = 1234;

		// proceso
		
		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(nombreAlumno, apellidoAlumno, dni);

		// test

		assertTrue(unlam.ingresarAlumno(alumno));
		assertEquals(alumno, unlam.buscarAlumno(alumno));

	}
}

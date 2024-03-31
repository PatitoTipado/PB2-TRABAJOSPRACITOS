package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import dominio.*;

public class testCallcenter {

	@Test
	public void siSePuedeIngresarUnNuevoContacto() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 5;
		// usuario
		String nombreDeContacto = "pepe";
		String apellido = "gomez";
		String email = "mauri@gmail.com";
		Integer celular = 1153895556;
		Integer codigoAlfanumerico = 54;
		Integer codigoPostal = 1755;
		Integer localidad = 10;
		Provincias provincia = Provincias.BUENOS_AIRES;
		// Diferentes numeros de celular deberian tener para que te dejen crear mas de 1

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);
		Contacto actual = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);

		// test

		assertTrue(nuevo.ingresarContactos(actual));

	}

	@Test
	public void siSePuedeIngresarUnNuevoContactoNull() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 5;

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);
		Contacto actual = null;

		// test

		assertFalse(nuevo.ingresarContactos(actual));

	}

	@Test
	public void queSePuedaIngresarMasDeUnContacto() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 5;
		// usuario
		String nombreDeContacto = "pepe";
		String apellido = "gomez";
		String email = "mauri@gmail.com";

		// celulares
		Integer celular = 1153895556, celular1 = 1153895557, celular2 = 113895558;

		Integer codigoAlfanumerico = 54;
		Integer codigoPostal = 1755;
		Integer localidad = 10;
		Provincias provincia = Provincias.BUENOS_AIRES;
		Integer salidaEsperada = 3;
		// Diferentes numeros de celular deberian tener para que te dejen crear mas de 1

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);
		Contacto actual = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual1 = new Contacto(nombreDeContacto, apellido, email, celular1, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual2 = new Contacto(nombreDeContacto, apellido, email, celular2, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		nuevo.ingresarContactos(actual);
		nuevo.ingresarContactos(actual1);
		nuevo.ingresarContactos(actual2);

		// test

		assertEquals(salidaEsperada, nuevo.getCantidadDeContactosTotales());

	}

	@Test
	public void queNoSePuedaIngresarMasQueLaCantidadPermitida() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 2;
		// usuario
		String nombreDeContacto = "pepe";
		String apellido = "gomez";
		String email = "mauri@gmail.com";

		// celulares
		Integer celular = 1153895556, celular1 = 1153895557, celular2 = 113895558;

		Integer codigoAlfanumerico = 54;
		Integer codigoPostal = 1755;
		Integer localidad = 10;
		Provincias provincia = Provincias.BUENOS_AIRES;
		Integer salidaEsperada = 2;
		// Diferentes numeros de celular deberian tener para que te dejen crear mas de 1

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);
		Contacto actual = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual1 = new Contacto(nombreDeContacto, apellido, email, celular1, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual2 = new Contacto(nombreDeContacto, apellido, email, celular2, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		nuevo.ingresarContactos(actual);
		nuevo.ingresarContactos(actual1);
		nuevo.ingresarContactos(actual2);

		// test

		assertEquals(salidaEsperada, nuevo.getCantidadDeContactosTotales());

	}

	@Test
	public void queNoSePuedaIngresarContactosQueExistanConElMismoNumero() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 5;
		// usuario
		String nombreDeContacto = "pepe";
		String apellido = "gomez";
		String email = "mauri@gmail.com";
		Integer celular = 1153895556;
		Integer codigoAlfanumerico = 54;
		Integer codigoPostal = 1755;
		Integer localidad = 10;
		Provincias provincia = Provincias.BUENOS_AIRES;
		Integer salidaEsperada = 1;
		// Diferentes numeros de celular deberian tener para que te dejen crear mas de 1

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);
		Contacto actual = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual1 = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual2 = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		nuevo.ingresarContactos(actual);
		nuevo.ingresarContactos(actual1);
		nuevo.ingresarContactos(actual2);

		// test

		assertEquals(salidaEsperada, nuevo.getCantidadDeContactosTotales());

	}

	@Test
	public void queNoSePuedaIngresarContactosConLosDatosInvalidos() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 5;
		// usuario
		String nombreDeContacto = "pepe";
		String apellido = "gomez";
		String email = "maurigmailcom";
		Integer celular = 12;
		Integer codigoAlfanumerico = 54;
		Integer codigoPostal = 1755;
		Integer localidad = 10;
		Provincias provincia = Provincias.BUENOS_AIRES;
		// Diferentes numeros de celular deberian tener para que te dejen crear mas de 1

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);
		Contacto actual = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);

		// test

		assertFalse((nuevo.ingresarContactos(actual)));

	}

	@Test
	public void queNoSePuedaIngresarMasContactosConEmailInvalidos() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 4;
		// usuario
		String nombreDeContacto = "pepe";
		String apellido = "gomez";
		String email = "maurigmailcom", email1 = "mauri@gmailcom", email2 = "maurigmail.sdd";

		// celulares
		Integer celular = 1153895556, celular1 = 1153895557, celular2 = 113895558;

		Integer codigoAlfanumerico = 54;
		Integer codigoPostal = 1755;
		Integer localidad = 10;
		Provincias provincia = Provincias.BUENOS_AIRES;
		Integer salidaEsperada = 0;
		// Diferentes numeros de celular deberian tener para que te dejen crear mas de 1

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);
		Contacto actual = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual1 = new Contacto(nombreDeContacto, apellido, email1, celular1, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual2 = new Contacto(nombreDeContacto, apellido, email2, celular2, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		nuevo.ingresarContactos(actual);
		nuevo.ingresarContactos(actual1);
		nuevo.ingresarContactos(actual2);

		// test

		assertEquals(salidaEsperada, nuevo.getCantidadDeContactosTotales());

	}

	@Test
	public void queNoSePuedaIngresarMasContactosConTelefonoInvalidos() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 2;
		// usuario
		String nombreDeContacto = "pepe";
		String apellido = "gomez";
		String email = "mauri@gmail.com";

		// celulares
		Integer celular = 12, celular1 = 23, celular2 = 2123;

		Integer codigoAlfanumerico = 54;
		Integer codigoPostal = 1755;
		Integer localidad = 10;
		Provincias provincia = Provincias.BUENOS_AIRES;
		Integer salidaEsperada = 0;
		// Diferentes numeros de celular deberian tener para que te dejen crear mas de 1

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);
		Contacto actual = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual1 = new Contacto(nombreDeContacto, apellido, email, celular1, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual2 = new Contacto(nombreDeContacto, apellido, email, celular2, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		nuevo.ingresarContactos(actual);
		nuevo.ingresarContactos(actual1);
		nuevo.ingresarContactos(actual2);

		// test

		assertEquals(salidaEsperada, nuevo.getCantidadDeContactosTotales());

	}

	@Test
	public void queNoSePuedaIngresarMasContactosConDatosInvalidos() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 2;
		// usuario
		String nombreDeContacto = "pepe";
		String apellido = "gomez";
		String email = "maurigmailcom";

		// celulares
		Integer celular = 12, celular1 = 122, celular2 = 21;

		Integer codigoAlfanumerico = 54;
		Integer codigoPostal = 1755;
		Integer localidad = 10;
		Provincias provincia = Provincias.BUENOS_AIRES;
		Integer salidaEsperada = 0;
		// Diferentes numeros de celular deberian tener para que te dejen crear mas de 1

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);
		Contacto actual = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual1 = new Contacto(nombreDeContacto, apellido, email, celular1, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual2 = new Contacto(nombreDeContacto, apellido, email, celular2, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		nuevo.ingresarContactos(actual);
		nuevo.ingresarContactos(actual1);
		nuevo.ingresarContactos(actual2);

		// test

		assertEquals(salidaEsperada, nuevo.getCantidadDeContactosTotales());

	}

	@Test
	public void queSePuedaRealizarUnaLlamada() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 5;
		// usuario
		String nombreDeContacto = "pepe";
		String apellido = "gomez";
		String email = "mauri@gmail.com";

		// celulares
		Integer celular = 1153895556, celular1 = 1153895557, celular2 = 113895558;

		Integer codigoAlfanumerico = 54;
		Integer codigoPostal = 1755;
		Integer localidad = 10;
		Provincias provincia = Provincias.BUENOS_AIRES;
		// Integer salidaEsperada = 3;
		// Diferentes numeros de celular deberian tener para que te dejen crear mas de 1

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);
		Contacto actual = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual1 = new Contacto(nombreDeContacto, apellido, email, celular1, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual2 = new Contacto(nombreDeContacto, apellido, email, celular2, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		nuevo.ingresarContactos(actual);
		nuevo.ingresarContactos(actual1);
		nuevo.ingresarContactos(actual2);

		// test

		assertTrue(nuevo.realizarUnaLLamada());
	}

	@Test
	public void queNoSePuedaRealizarUnaLlamadaSiNoHayContactos() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 5;

		// Diferentes numeros de celular deberian tener para que te dejen crear mas de 1

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);

		// test

		assertFalse(nuevo.realizarUnaLLamada());
	}

	@Test
	public void queSePuedaRealizarMasDeUnaLlamada() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 5;
		// usuario
		String nombreDeContacto = "pepe";
		String apellido = "gomez";
		String email = "mauri@gmail.com";

		// celulares
		Integer celular = 1153895556, celular1 = 1153895557, celular2 = 113895558;

		Integer codigoAlfanumerico = 54;
		Integer codigoPostal = 1755;
		Integer localidad = 10;
		Provincias provincia = Provincias.BUENOS_AIRES;
		Integer salidaEsperada = 3;
		// Diferentes numeros de celular deberian tener para que te dejen crear mas de 1

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);
		Contacto actual = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual1 = new Contacto(nombreDeContacto, apellido, email, celular1, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual2 = new Contacto(nombreDeContacto, apellido, email, celular2, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		nuevo.ingresarContactos(actual);
		nuevo.ingresarContactos(actual1);
		nuevo.ingresarContactos(actual2);
		nuevo.realizarUnaLLamada();
		nuevo.realizarUnaLLamada();
		nuevo.realizarUnaLLamada();

		// test

		assertEquals(salidaEsperada, nuevo.getCantidadDeLlamadas());
	}

	@Test
	public void queNoSePuedaRealizarMasDeLlamadasPermitidas() {

		// preparacion de datos

		Integer cantidadDeLlamadas = 5;
		Integer cantidadDeContactos = 5;
		// usuario
		String nombreDeContacto = "pepe";
		String apellido = "gomez";
		String email = "mauri@gmail.com";

		// celulares
		Integer celular = 1153895556, celular1 = 1153895557, celular2 = 113895558;

		Integer codigoAlfanumerico = 54;
		Integer codigoPostal = 1755;
		Integer localidad = 10;
		Provincias provincia = Provincias.BUENOS_AIRES;
		Integer salidaEsperada = 0;
		// Diferentes numeros de celular deberian tener para que te dejen crear mas de 1

		// ejecucion

		Callcenter nuevo = new Callcenter(cantidadDeContactos, cantidadDeLlamadas);
		Contacto actual = new Contacto(nombreDeContacto, apellido, email, celular, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual1 = new Contacto(nombreDeContacto, apellido, email, celular1, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		Contacto actual2 = new Contacto(nombreDeContacto, apellido, email, celular2, codigoAlfanumerico, codigoPostal,
				localidad, provincia);
		nuevo.ingresarContactos(actual);
		nuevo.ingresarContactos(actual1);
		nuevo.ingresarContactos(actual2);
		actual1.quieroDejarDeSerLlamado();
		actual.quieroDejarDeSerLlamado();
		actual2.quieroDejarDeSerLlamado();
		nuevo.realizarUnaLLamada();
		nuevo.realizarUnaLLamada();
		nuevo.realizarUnaLLamada();

		// test

		assertEquals(salidaEsperada, nuevo.getCantidadDeLlamadas());
	}

	/*
	 * TODO: REVISAR DISTINTOS TIPOS DE TEST, caja blanca, caja negra, caja gris
	 * 
	 * hay 2 tipos de constructores. cuando pasas valores estas haciendo un
	 * constructor por asociacion:
	 * 
	 * estas asociciando otro objeto para crear otro y
	 * 
	 * por compocision:
	 * 
	 * estas componiendo un objeto a partir del otro, creas un objeto
	 * 
	 * Clase 3:
	 * 
	 * ArrayList, rapides al buscar, lenta capacidad para ingresar o eliminar
	 * 
	 * linkedList, rapides al ingresar o eliminar, "lentitud" para buscar
	 * 
	 * hashcode: el hashcode, existe en el objeto padre de todos los objetos, en la
	 * clase objet. por lo cual cuando queremos usarlo habria que sobreescribirlo,
	 * junto al metodo equeals
	 * 
	 * ¿para que nos sirve sobreescribir estos metodos?
	 * 
	 * Sobreescribimos estos metodos por que nosotros buscamos darle otra funcion al
	 * metodo que el que le da la clase padre, que es comparar el toString(posicion
	 * de memoria de la misma)
	 * 
	 * Nosotros para comparar si dos objetos son iguales, comparamos los atributos y
	 * esa es la sobreescritura que le hacemos a estos dos metodos, ya no comparamos
	 * la posicion de memoria, sino que comparamos los atributos que nos importan
	 * 
	 */

}

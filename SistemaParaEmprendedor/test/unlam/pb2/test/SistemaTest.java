package unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import unlam.pb2.dominio.*;

public class SistemaTest {

	@Test
	public void empleadoPlantaTemporariaConEsposaSinHijosOchentaHorasTrabajadas() {

		Boolean esCasado = true;
		Integer cantidadHijos = 0;
		Integer cantidadDeHoras = 80;
		Integer cuit = 0001;
		String razonSocial = "planta temporaria";

		EmpleadoPlantaTemporaria plantaTemporaria = new EmpleadoPlantaTemporaria(esCasado, cuit, razonSocial,
				cantidadHijos);

		Integer esperado = 16100;
		Integer actual = plantaTemporaria.calcularSalario(cantidadDeHoras);

		assertEquals(esperado, actual);

	}

	@Test
	public void empleadoPlantaPermanenteConEsposaDosHijosOchentaHorasTrabajadasSeisAniosAntiguedad() {

		Boolean esCasado = true;
		Integer cantidadHijos = 2;
		Integer cantidadDeHoras = 80;
		Integer cuit = 0002;
		String razonSocial = "planta permanente";
		Integer aniosAntiguedad = 6;

		EmpleadoPlantaPermanente plantaTemporaria = new EmpleadoPlantaPermanente(esCasado, cuit, razonSocial,
				aniosAntiguedad, cantidadHijos);

		Integer esperado = 25100;
		Integer actual = plantaTemporaria.calcularSalario(cantidadDeHoras);

		assertEquals(esperado, actual);

	}

	@Test
	public void empleadoDePlantaPermanenteNoGerenteCon160HorasTrabajadasSinEsposaSinHijos4aniosAntiguedad() {

		Boolean esCasado = false;
		Integer cantidadHijos = 0;
		Integer cantidadDeHoras = 160;
		Integer cuit = 0003;
		String razonSocial = "planta permanente";
		Integer aniosAntiguedad = 4;

		EmpleadoPlantaPermanente plantaPermanente = new EmpleadoPlantaPermanente(esCasado, cuit, razonSocial,
				aniosAntiguedad, cantidadHijos);

		Integer esperado = 48400;
		Integer actual = plantaPermanente.calcularSalario(cantidadDeHoras);

		assertEquals(esperado, actual);

	}

	@Test
	public void gerenteCon160HorasTrabajadasConEsposaUnHijo10AniosDeAntiguedad() {

		Boolean esCasado = true;
		Integer cantidadHijos = 1;
		Integer cantidadDeHoras = 160;
		Integer cuit = 0004;
		String razonSocial = "gerente";
		Integer aniosAntiguedad = 10;

		Gerente gerente = new Gerente(esCasado, cuit, razonSocial, aniosAntiguedad, cantidadHijos);

		Integer esperado = 65800;
		Integer actual = gerente.calcularSalario(cantidadDeHoras);

		assertEquals(esperado, actual);

	}

	@Test
	public void empresaConCuatroEmpleadosAccedeALosEmpleadosYSueldos() {

		Boolean esCasado = true;
		Boolean isNoCasado = false;
		Integer cantidadHijos = 1;
		Integer cuit = 0004;
		String razonSocial = "gerente";
		Integer aniosAntiguedadDiez = 10;

		Gerente gerente = new Gerente(esCasado, cuit, razonSocial, aniosAntiguedadDiez, cantidadHijos);

		Integer cantidadHijosCero = 0;
		Integer cuitTres = 0003;
		String razonSocialPlantaPermanente = "planta permanente";
		Integer aniosAntiguedadCuatro = 4;

		EmpleadoPlantaPermanente empleadoPlantaPermanenteCientoSesentaHoras = new EmpleadoPlantaPermanente(isNoCasado,
				cuitTres, razonSocialPlantaPermanente, aniosAntiguedadCuatro, cantidadHijosCero);

		Integer cantidadHijosDos = 2;
		Integer cuitDos = 0002;
		Integer aniosAntiguedad = 6;

		EmpleadoPlantaPermanente empleadoPlantaPermanenteOchentaHoras = new EmpleadoPlantaPermanente(esCasado, cuitDos,
				razonSocialPlantaPermanente, aniosAntiguedad, cantidadHijosDos);

		Integer cuitUno = 0001;
		String razonSocialPlantaTemporaria = "planta temporaria";

		EmpleadoPlantaTemporaria plantaTemporaria = new EmpleadoPlantaTemporaria(esCasado, cuitUno,
				razonSocialPlantaTemporaria, cantidadHijosCero);

		Sistema sistema = new Sistema();

		sistema.agregarEmpleado(gerente);
		sistema.agregarEmpleado(empleadoPlantaPermanenteCientoSesentaHoras);
		sistema.agregarEmpleado(empleadoPlantaPermanenteOchentaHoras);
		sistema.agregarEmpleado(plantaTemporaria);

		Integer cantidadEmpleadosExperado = 4;
		Integer cantidadEmpleadosTotal = sistema.cantidadTotalEmpleados();

		assertEquals(cantidadEmpleadosExperado, cantidadEmpleadosTotal);
	}
}

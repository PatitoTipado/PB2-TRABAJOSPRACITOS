package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.*;

public class FigurasGeometricasTest {

	@Test
	public void queSePuedaMoverUnCirculo() {

		Double coordenadaX = 2.0;
		Double coordenadaY = 2.0;
		Double radio = 5.0;

		Punto inicio = new Punto(coordenadaX, coordenadaY);
		Circulo figura = new Circulo(inicio, radio);
		figura.moverseEnElplano(coordenadaX, coordenadaY);

		String esperado = "Punto [x=" + 4.0 + ", y=" + 4.0 + "]";
		assertEquals(esperado, figura.getCentro().toString());
	}

	@Test
	public void calcularElAreaDeUnCirculo() {

		Double coordenadaX = 2.0;
		Double coordenadaY = 2.0;
		Double radio = 5.0;

		Punto inicio = new Punto(coordenadaX, coordenadaY);
		Circulo figura = new Circulo(inicio, radio);

		Double esperado = Math.PI * 25;
		assertEquals(esperado, figura.calcularArea());
	}

	@Test
	public void queSePuedaMoverUnElipse() {

		Double coordenadaX = 2.0;
		Double coordenadaY = 2.0;
		Double radioMayor = 5.0;
		Double radioMenor = 4.0;

		Punto inicio = new Punto(coordenadaX, coordenadaY);
		Elipse figura = new Elipse(inicio, radioMayor, radioMenor);
		figura.moverseEnElplano(coordenadaX, coordenadaY);

		String esperado = "Punto [x=" + 4.0 + ", y=" + 4.0 + "]";
		assertEquals(esperado, figura.getCentro().toString());
	}

	@Test
	public void calcularElAreaDeUnElipse() {

		Double coordenadaX = 2.0;
		Double coordenadaY = 2.0;
		Double radioMayor = 5.0;
		Double radioMenor = 4.0;

		Punto inicio = new Punto(coordenadaX, coordenadaY);
		Elipse figura = new Elipse(inicio, radioMayor, radioMenor);

		Double esperado = Math.PI * 20.0;
		assertEquals(esperado, figura.calcularArea());
	}

	@Test
	public void queSePuedaMoverUnCuadrado() {

		Double coordenadaX = 2.0;
		Double coordenadaY = 2.0;
		Double lado = 2.0;

		Punto inferior = new Punto(coordenadaX, coordenadaY);
		Punto superior = new Punto(coordenadaX, coordenadaY);

		Cuadrado figura = new Cuadrado(inferior, superior, lado);
		figura.moverseEnElPlano(inferior, superior);

		String esperado = "Punto [x=" + 4.0 + ", y=" + 4.0 + "]";

		assertEquals(esperado, figura.getPuntoInferior().toString());
		assertEquals(esperado, figura.getPuntoSuperior().toString());

	}

	@Test
	public void queSePuedaMoverUnRectangulo() {

		Double coordenadaX = 2.0;
		Double coordenadaY = 2.0;
		Double base = 2.0;
		Double altura = 2.0;

		Punto inferior = new Punto(coordenadaX, coordenadaY);
		Punto superior = new Punto(coordenadaX, coordenadaY);

		Rectangulo figura = new Rectangulo(inferior, superior, base, altura);
		figura.moverseEnElPlano(inferior, superior);

		String esperado = "Punto [x=" + 4.0 + ", y=" + 4.0 + "]";

		assertEquals(esperado, figura.getPuntoInferior().toString());
		assertEquals(esperado, figura.getPuntoSuperior().toString());

	}

	@Test
	public void calcularElAreaDeUnRectangulo() {

		Double coordenadaX = 2.0;
		Double coordenadaY = 2.0;
		Double base = 2.0;
		Double altura = 2.0;

		Punto inferior = new Punto(coordenadaX, coordenadaY);
		Punto superior = new Punto(coordenadaX, coordenadaY);

		Rectangulo figura = new Rectangulo(inferior, superior, base, altura);

		Double esperado = 4.0;

		assertEquals(esperado, figura.calcularArea());

	}

	@Test
	public void calcularElAreaDelCuadrado() {

		Double coordenadaX = 2.0;
		Double coordenadaY = 2.0;
		Double lado = 2.0;

		Punto inferior = new Punto(coordenadaX, coordenadaY);
		Punto superior = new Punto(coordenadaX, coordenadaY);

		Cuadrado figura = new Cuadrado(inferior, superior, lado);

		Double esperado = 4.0;
		assertEquals(esperado, figura.calcularArea());

	}

	@Test
	public void calcularElAreaTotalDeTodasLasFiguras() {

		Double coordenadaX = 2.0;
		Double coordenadaY = 2.0;
		Double lado = 2.0;
		Integer iterar=5;

		Punto inferior = new Punto(coordenadaX, coordenadaY);
		Punto superior = new Punto(coordenadaX, coordenadaY);
		Double radio = 5.0;

		Punto inicio = new Punto(coordenadaX, coordenadaY);
		Circulo figuraRedonda = new Circulo(inicio, radio);

		Cuadrado figuraCuadrada = new Cuadrado(inferior, superior, lado);
		SistemaFiguraGeometrica sistema = new SistemaFiguraGeometrica();

		for (int i = 0; i <iterar ; i++) {
			sistema.ingresarFigura(figuraCuadrada);
		}
		for (int i = 0; i < iterar; i++) {
			sistema.ingresarFigura(figuraRedonda);
		}
		
		Double esperado = 20+ ((Math.PI * 25)*5);

		assertEquals(esperado, sistema.areaTotalDeTodasLasFiguras());

	}

}

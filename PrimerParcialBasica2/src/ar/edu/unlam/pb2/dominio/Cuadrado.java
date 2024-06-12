package ar.edu.unlam.pb2.dominio;

public class Cuadrado extends FiguraGeometricaCuadrada {

	// entiendo que todos los lados del cuadrado son iguales
	private Double lado;

	public Cuadrado(Punto puntoInferior, Punto puntoSuperior, Double lado) {
		super(puntoInferior, puntoSuperior);
		this.lado = lado;
	}

	@Override
	public Double calcularArea() {
		return lado*lado;
	}

}

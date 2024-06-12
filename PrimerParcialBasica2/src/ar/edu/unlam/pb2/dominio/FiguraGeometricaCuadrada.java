package ar.edu.unlam.pb2.dominio;

public abstract class FiguraGeometricaCuadrada extends Figura {

	protected Punto puntoInferior;
	protected Punto puntoSuperior;
	
	public FiguraGeometricaCuadrada(Punto puntoInferior, Punto puntoSuperior) {
		super();
		this.puntoInferior = puntoInferior;
		this.puntoSuperior = puntoSuperior;
	}

	public void moverseEnElPlano(Punto inferior,Punto superior) {
		puntoInferior.moverEnX(inferior.getX());
		puntoInferior.moverEnY(inferior.getY());
		puntoSuperior.moverEnX(superior.getX());
		puntoSuperior.moverEnY(superior.getY());
	}

	public abstract Double calcularArea();
	
	public Punto getPuntoInferior() {
		return puntoInferior;
	}
	
	public Punto getPuntoSuperior() {
		return puntoSuperior;
	}
	
}

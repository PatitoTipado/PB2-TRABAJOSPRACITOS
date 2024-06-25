package ar.edu.unlam.pb2.dominio;

public abstract class FiguraGeometricaRedonda extends Figura {

	public Punto getCentro() {
		return centro;
	}

	protected Punto centro;

	public FiguraGeometricaRedonda(Punto centro) {
		super();
		this.centro = centro;		
	}

	public void moverseEnElplano(Double deltaX, Double deltaY) {
		// entiendo que puede ingresarse numeros negativos,para moverse el plano es como
		// mover de arriba (positivo) a abajo (negativos)
		centro.moverEnX(deltaX);
		centro.moverEnY(deltaY);
	}

	
}

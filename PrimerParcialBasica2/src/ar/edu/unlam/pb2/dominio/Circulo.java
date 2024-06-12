package ar.edu.unlam.pb2.dominio;

public class Circulo extends FiguraGeometricaRedonda{

	private Double radio;
	
	public Circulo(Punto centro,Double radio) {
		super(centro);
		this.radio=radio;
	}

	@Override
	public Double calcularAreaFigura() {
		return Math.PI*(radio*radio);
	}

}

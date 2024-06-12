package ar.edu.unlam.pb2.dominio;

public class Rectangulo extends FiguraGeometricaCuadrada{

	private Double base;
	private Double altura;
	
	public Rectangulo(Punto puntoInferior, Punto puntoSuperior,Double base,Double altura) {
		super(puntoInferior, puntoSuperior);
		this.base=base; //seria la base inf y sup
		this.altura=altura; //serian los lados
	}

	@Override
	public Double calcularArea() {
		return base*altura;
	}


}

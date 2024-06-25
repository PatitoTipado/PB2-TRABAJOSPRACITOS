package ar.edu.unlam.pb2.dominio;

public class Elipse extends FiguraGeometricaRedonda {

	private Double radioMayor;
	private Double radioMenor;

	public Elipse(Punto centro, Double radioMayor, Double radioMenor) {
		super(centro);
		// en esta primera entrega no vere el tema de que ambas tiene que ser positivas,
		// ya que si son negativas se irian para le otro lado
		this.radioMayor = radioMayor;
		this.radioMenor = radioMenor;
	}

	@Override
	public Double calcularArea() {

		return Math.PI*radioMenor*radioMayor;
	}

}

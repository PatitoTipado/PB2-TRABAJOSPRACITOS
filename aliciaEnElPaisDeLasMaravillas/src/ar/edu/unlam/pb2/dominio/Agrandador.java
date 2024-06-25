package ar.edu.unlam.pb2.dominio;

public class Agrandador extends Alimento {

	public Agrandador(String nombreAlimento) {
		super(nombreAlimento);
	}

	public Double getValor() {
		return 200.0;
	}

	@Override
	public Double habilidad() {
		return 40.0;
	}

	@Override
	public String tipoDeAlimento() {
		return "agrandador";
	}

}

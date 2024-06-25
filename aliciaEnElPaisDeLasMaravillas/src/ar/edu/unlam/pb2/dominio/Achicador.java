package ar.edu.unlam.pb2.dominio;

public class Achicador extends Alimento {

	public Achicador(String nombreAlimento) {
		super(nombreAlimento);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double habilidad() {
		return 50.0;
	}

	@Override
	public String tipoDeAlimento() {
		return "achicador";
	}

	@Override
	public Double getValor() {
		return 300.0;
	}

}

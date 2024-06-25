package ar.edu.unlam.pb2.dominio;

public abstract class Alimento implements Comparable<Alimento> {

	public String getNombreAlimento() {
		return nombreAlimento;
	}

	protected String nombreAlimento;

	public Alimento(String nombreAlimento) {
		super();
		this.nombreAlimento = nombreAlimento;
	}

	public abstract Double habilidad();

	protected abstract String tipoDeAlimento();

	protected abstract Double getValor();

	@Override
	public int compareTo(Alimento o) {
		return this.getNombreAlimento().compareTo(o.getNombreAlimento());
	}

}

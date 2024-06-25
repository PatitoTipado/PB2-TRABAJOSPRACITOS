package ar.edu.unlam.pb2.dominio;

public class Expelliarmus extends Hechizo {
	
	private String nombreDeHechizo;
	
	public Expelliarmus() {
		super();
		this.nombreDeHechizo ="expelliarmus";	}

	@Override
	public String getNombre() {
		return this.nombreDeHechizo;
	}

	@Override
	public void aplicarHechizo(Hechizable objetoHechizable) {
		objetoHechizable.setHechizo(this.nombreDeHechizo);
	}

}

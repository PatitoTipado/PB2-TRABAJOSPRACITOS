package ar.edu.unlam.pb2.dominio;

public class Agrandar extends Hechizo {

	
	public Agrandar(String nombreDeHechizo) {
		super(nombreDeHechizo);
	}

	@Override
	public String getNombre() {
		return super.nombreDeHechizo;
	}

	@Override
	public void aplicarHechizo(Hechizable objetoHechizable) {
		objetoHechizable.setHechizo(super.nombreDeHechizo);
	}

}

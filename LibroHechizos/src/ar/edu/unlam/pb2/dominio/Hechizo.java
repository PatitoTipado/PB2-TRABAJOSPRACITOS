package ar.edu.unlam.pb2.dominio;

public abstract class Hechizo {
	
	protected String nombreDeHechizo;
	
	public Hechizo(String string) {
		this.nombreDeHechizo=string;
	}
	public Hechizo() {
	}

	public abstract String getNombre();

	public abstract void aplicarHechizo(Hechizable perro);
	
	public String getNombreDeHechizo() {
		return nombreDeHechizo;
	}
}

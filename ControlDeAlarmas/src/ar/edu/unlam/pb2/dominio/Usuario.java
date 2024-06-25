package ar.edu.unlam.pb2.dominio;

public class Usuario {

	public static final String CONFIGURADOR = "CONFIGURADOR";
	public static final String ACTIVADOR = "ACTIVADOR";
	private String nombre;
	private String tipoUsuario;

	public Usuario(String nombre, String tipo) {

		this.tipoUsuario = tipo;
		this.nombre = nombre;
	}

	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

}

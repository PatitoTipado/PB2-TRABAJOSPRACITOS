package ar.edu.unlam.pb2.dominio;

import java.util.*;

public class Alarma {

	public void setCodigoConfiguracion(String codigoConfiguracion) {
		this.codigoConfiguracion = codigoConfiguracion;
	}

	private String nombre;
	private Integer codigoActivacion;
	private LinkedList<Usuario> usuarios = new LinkedList<>();
	private static Integer codigoAux = 0;
	private Integer ID = codigoAux;
	private String codigoConfiguracion;

	public Alarma(String nombre, Integer codigoActivacion) {

		this.nombre = nombre;
		this.codigoActivacion = codigoActivacion;
		codigoAux++;
	}

	public Alarma(String nombre, Integer codigoActivacion, String codigoConfiguracion) {

		this.nombre = nombre;
		this.codigoActivacion = codigoActivacion;
		this.codigoConfiguracion = codigoConfiguracion;
		codigoAux++;
	}

	public boolean agregarUsuario(Usuario usuario) throws NoEsUnUsuarioConfiguradorExeptions {

		if (usuario != null && usuario.getTipoUsuario().equals(Usuario.CONFIGURADOR)) {
			return usuarios.add(usuario);
		} else if (usuario != null && usuario.getTipoUsuario().equals(Usuario.ACTIVADOR)) {
			return usuarios.add(usuario);
		}
		throw new NoEsUnUsuarioConfiguradorExeptions();
	}

	public Integer getId() {
		return this.ID;
	}

}

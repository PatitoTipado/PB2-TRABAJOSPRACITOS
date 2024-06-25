package ar.edu.unlam.pb2.dominio;

import java.util.*;

public class Central {

	private TreeMap<Integer, Alarma> alarmas = new TreeMap<>();
	private LinkedList<Usuario> usuarios = new LinkedList<>();

	public boolean agregarAlarma(Alarma alarma) {

		return alarmas.put(alarma.getId(), alarma) == null;
	}

	public boolean agregarUsuario(Usuario usuario) {

		if (esUnUsuarioValido(usuario)) {
			return usuarios.add(usuario);
		}

		return false;
	}

	public void agregarUsuarioAUnaAlarma(Integer dniUsuarioAAgregar, Integer idAlarma, String codigoConfiguracionAlarma)
			throws CodigoAlarmaIncorrectoException, NoEsUnUsuarioConfiguradorExeptions {

		if (alarmas.containsKey(idAlarma)) {
			alarmas.get(idAlarma).agregarUsuario(new Usuario("", "CONFIGURADOR"));
			alarmas.get(idAlarma).setCodigoConfiguracion(codigoConfiguracionAlarma);
			return;
		}

		throw new CodigoAlarmaIncorrectoException();
	}

	private boolean esUnUsuarioValido(Usuario usuario) {
		return usuario != null && usuario.getTipoUsuario().equals(Usuario.CONFIGURADOR)
				|| usuario.getTipoUsuario().equals(Usuario.ACTIVADOR);
	}

}

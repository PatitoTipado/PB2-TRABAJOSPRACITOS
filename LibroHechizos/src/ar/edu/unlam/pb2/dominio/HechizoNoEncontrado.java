package ar.edu.unlam.pb2.dominio;

public class HechizoNoEncontrado extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -409687220060875175L;

	public HechizoNoEncontrado() {
		super("El hechizo no fue encontrado");
	}

}

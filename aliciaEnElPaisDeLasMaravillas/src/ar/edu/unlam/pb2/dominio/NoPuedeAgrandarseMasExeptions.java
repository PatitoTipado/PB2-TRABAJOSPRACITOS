package ar.edu.unlam.pb2.dominio;

public class NoPuedeAgrandarseMasExeptions extends Exception {

	public NoPuedeAgrandarseMasExeptions() {
		super("no se puede agrandar mas");
	}

	private static final long serialVersionUID = 1982589045635335654L;

}

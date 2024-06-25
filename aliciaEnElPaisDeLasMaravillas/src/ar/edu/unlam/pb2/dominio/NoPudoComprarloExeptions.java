package ar.edu.unlam.pb2.dominio;

public class NoPudoComprarloExeptions extends Exception {

	public NoPudoComprarloExeptions() {
		super("No puede comprarlo");
	}

	private static final long serialVersionUID = 1L;

}

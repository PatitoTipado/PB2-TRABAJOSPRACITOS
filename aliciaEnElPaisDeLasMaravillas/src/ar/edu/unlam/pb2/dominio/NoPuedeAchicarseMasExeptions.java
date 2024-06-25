package ar.edu.unlam.pb2.dominio;

public class NoPuedeAchicarseMasExeptions extends Exception {

	public NoPuedeAchicarseMasExeptions() {
		super("no se puede achicar mas");
	}

	private static final long serialVersionUID = 3636448146074699282L;

}

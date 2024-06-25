package ar.edu.unlam.pb2.dominio;

public class ParticipanteNoCalificadoExeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParticipanteNoCalificadoExeption() {
		super("Participante descalificado");
	}

}

package ar.edu.unlam.pb2.dominio;

import java.util.*;

public class Torneo {

	Map<Integer, Arquero> torneo = new TreeMap<>();

	public void agregarParticipante(Arquero arquero) throws ParticipanteNoCalificadoExeption {
		torneo.put(arquero.obtenerPuntajeTotal(), arquero);
	}

	public TreeMap<Integer, Arquero> obtenerPodio() {

		TreeMap<Integer, Arquero> podio = new TreeMap<>(Collections.reverseOrder());

		podio.putAll(this.torneo);

		return podio;
	}

}

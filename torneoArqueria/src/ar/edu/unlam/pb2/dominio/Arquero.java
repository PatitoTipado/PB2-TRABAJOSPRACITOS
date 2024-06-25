package ar.edu.unlam.pb2.dominio;

import java.util.*;

public class Arquero implements Comparable<Arquero> {

	private static Integer codigo = 0;
	private Integer ID;
	private LinkedList<Tiro> tiros = new LinkedList<Tiro>();

	public Arquero() {
		ID = codigo;
		codigo++;
	}

	public Boolean realizarDisparo(Double coordenadaX, Double coordenadaY) throws TiroInvalidoExeption {

		Tiro nuevo = new Tiro(coordenadaX, coordenadaY);

		if (nuevo.getValido()) {
			return tiros.add(nuevo);
		}
		throw new TiroInvalidoExeption("El tiro no es valido");
	}

	public Integer getCantidadDeDisparosRealizados() {
		return tiros.size();
	}

	public Boolean contieneCincoDisparosValidos() {
		return getCantidadDeDisparosRealizados() >= 5;
	}

	public List<Tiro> losCincoMejoresTiros() throws ParticipanteNoCalificadoExeption {
		Collections.sort(this.tiros);
		
		List <Tiro> losCincoMejores= new LinkedList<>();
		if (contieneCincoDisparosValidos()) {
			for (int i = 0; i < 5; i++) {
				losCincoMejores.add(tiros.get(i));
			}
			return losCincoMejores;
		}
		throw new ParticipanteNoCalificadoExeption();
	}

	@Override
	public String toString() {
		return "Arquero [ID=" + ID;
	}

	public Integer obtenerPuntajeTotal() throws ParticipanteNoCalificadoExeption {
		Integer puntajeTotal = 0;

		for (Tiro tiro : losCincoMejoresTiros()) {
			puntajeTotal += tiro.puntaje();
		}

		return puntajeTotal;
	}

	@Override
	public int compareTo(Arquero o) {
		return ID.compareTo(ID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arquero other = (Arquero) obj;
		return Objects.equals(ID, other.ID);
	}

}

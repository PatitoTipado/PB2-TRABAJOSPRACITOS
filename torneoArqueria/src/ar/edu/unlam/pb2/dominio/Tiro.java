package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public class Tiro implements Comparable<Tiro> {

	private static final int INDICE = 2;
	private Double coordenadaX;
	private Double coordenadaY;
	private Boolean esValido;

	public Tiro(Double coordenadaX, Double coordenadaY) {
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		if(distancia()>0 && distancia()<50) {
			esValido=true;
		}else {
			esValido=false;
		}
	}

	public Double distancia()  {

		Double distancia = Math.sqrt(Math.pow(this.coordenadaX, INDICE) + Math.pow(this.coordenadaY, INDICE));

		if (distancia > 0 && distancia < 50) {
			this.esValido = true;
		}
		return distancia;

	}

	public Integer puntaje() {

		Integer puntaje = -1;

		if (esValido) {
			if (distancia() >= 0.0 && distancia() <= 10.0) {
				puntaje = 1000;
			} else if (distancia() > 10 && distancia() <= 20) {
				puntaje = 500;
			} else if (distancia() > 20 && distancia() <= 30) {
				puntaje = 200;
			} else if (distancia() > 30 && distancia() <= 40) {
				puntaje = 100;
			} else if (distancia() > 40 && distancia() <= 50) {
				puntaje = 50;
			}
		}

		return puntaje;
	}

	public Double getCoordenadaX() {
		return this.coordenadaX;
	}

	public Double getCoordenadaY() {
		return this.coordenadaY;
	}

	@Override
	public int compareTo(Tiro o) {
		return o.puntaje().compareTo(this.puntaje());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(coordenadaX, coordenadaY);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tiro other = (Tiro) obj;
		return Objects.equals(coordenadaX, other.coordenadaX) && Objects.equals(coordenadaY, other.coordenadaY);
	}

	@Override
	public String toString() {
		return "Tiro [distancia()=" + distancia() + ", puntaje()=" + puntaje() + "]";
	}

	public boolean getValido() {
		return this.esValido;
	}

}

package ar.edu.unlam.pb2.dominio;

import java.util.Comparator;

public class PropiedadValorComparatorPorUbicacion implements Comparator<Propiedad> {

	public int compare(Propiedad o1, Propiedad o2) {

        return o1.getUbicacion().compareTo(o2.getUbicacion());
	}

}

package ar.edu.unlam.pb2.dominio;
import java.util.Comparator;

public class PropiedadValorComparatorPorPrecio implements Comparator<Propiedad> {
	public int compare(Propiedad p1, Propiedad p2) {
        return Integer.compare(p2.getValor(),p1.getValor());
    }
}

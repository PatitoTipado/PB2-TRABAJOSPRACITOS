package ar.edu.unlam.pb2.dominio;

import java.util.*;

public class SistemaFiguraGeometrica {

	private List<Figura> figuras = new ArrayList<Figura>();

	public Boolean ingresarFigura(Figura figura) {
		return figuras.add(figura);
	}

	// calcular el area total de todas las figuras

	public Double areaTotalDeTodasLasFiguras() {

		Double areaTotal = 0.0;

		for (Figura figura : figuras) {
			areaTotal+=figura.calcularArea();
		}
		
		return areaTotal;
	}

}

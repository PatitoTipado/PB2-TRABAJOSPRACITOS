package ar.edu.unlam.pb2.dominio;

import java.util.*;

public class SistemaFiguraGeometrica {

	private List<FiguraGeometricaCuadrada> figurasCuadradas = new ArrayList<FiguraGeometricaCuadrada>();
	private List<FiguraGeometricaRedonda> figurasRedondas = new ArrayList<FiguraGeometricaRedonda>();

	public Boolean ingresarFigurasCuadrada(FiguraGeometricaCuadrada figura) {
		return figurasCuadradas.add(figura);
	}
	public Boolean ingresarFigurasRedonda(FiguraGeometricaRedonda figura) {
		return figurasRedondas.add(figura);
	}

	// calcular el area total de todas las figuras

	public Double areaTotalDeTodasLasFiguras() {

		Double areaTotal = 0.0;

		for (FiguraGeometricaCuadrada cuadradas : figurasCuadradas) {
			areaTotal+= cuadradas.calcularArea();
		}

		for (FiguraGeometricaRedonda redondas : figurasRedondas) {
			areaTotal+=redondas.calcularAreaFigura();
		}
		
		return areaTotal;
	}

}

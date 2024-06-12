package ar.edu.unlam.pb2.test;

import ar.edu.unlam.pb2.dominio.Inmoviliaria;
import ar.edu.unlam.pb2.dominio.Propiedad;

public class Test {

	public static void main(String[] args) {
		Inmoviliaria inmoviliaria= new Inmoviliaria();
		
		inmoviliaria.agregarPropiedad(new Propiedad());
		inmoviliaria.agregarPropiedad(new Propiedad());
		inmoviliaria.agregarPropiedad(new Propiedad());
		inmoviliaria.agregarPropiedad(new Propiedad());

		for (int i = 0; i < inmoviliaria.obtenerPropiedadesOrdenadasPorPrecio().size(); i++) {
			System.out.println(inmoviliaria.obtenerPropiedadesOrdenadasPorPrecio().get(i));
		}

	}

}

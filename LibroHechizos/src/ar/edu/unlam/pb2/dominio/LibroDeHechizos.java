package ar.edu.unlam.pb2.dominio;

import java.util.*;

public class LibroDeHechizos {

	Map <String,Hechizo> hechizos= new TreeMap<>();
	
	public void agregarHechizo(Hechizo hechizo) {
		this.hechizos.put(hechizo.getNombre(), hechizo);
	}

	public Hechizo buscar(String string) throws HechizoNoEncontrado{
				
		if( hechizos.get(string) != null) {
			return hechizos.get(string);
		}
		
		throw new HechizoNoEncontrado();
	}

}

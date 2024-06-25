package ar.edu.unlam.pb2.dominio;

import java.util.*;

public class Propiedad {
	
	protected Integer codigo;
	protected Integer valor;
	protected Boolean estaEnVenta;
	private static Integer chanchada=0;
	private String ubicacion;
	private boolean estaEnAlquiler;
	private List <Cliente> inquilinos= new ArrayList<Cliente>();
	
	public Propiedad() {
		super();
		
		chanchada++;
		valor=chanchada;
		codigo=chanchada;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public int getValor() {
		return this.valor;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public boolean getestaEnVenta() {
		return this.estaEnVenta;
	}

	public boolean getestaEnAlquiler() {
		return this.estaEnAlquiler;
	}
	@Override
	public String toString() {
		return "Propiedad [codigo=" + codigo + ", valor=" + valor + "]";
	}

	public boolean agregarInquilino(Cliente alquilador) {

		return inquilinos.add(alquilador);
	}
	
}